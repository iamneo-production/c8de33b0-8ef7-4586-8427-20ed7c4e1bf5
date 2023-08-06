package com.hackathon.imageservice.controller;

import com.hackathon.imageservice.DAO.NotificationDTO;
import com.hackathon.imageservice.DAO.UploadedImageDAO;
import com.hackathon.imageservice.extern.DatabaseFeignClient;
import com.hackathon.imageservice.extern.ImageAnalysisFeignClient;
import com.hackathon.imageservice.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    DatabaseFeignClient databaseFeignClient;

    @Autowired
    ImageAnalysisFeignClient imageAnalysisFeignClient;

    @PostMapping("/upload")
    public ResponseEntity<NotificationDTO> uploadImage(@RequestParam("file")MultipartFile file){
        try {

            if(file == null || !file.getContentType().startsWith("image")){
                throw new Exception("File is not an Image");
            }

            // saving image to database
            Image image = new Image(file.getBytes(), file.getOriginalFilename(), file.getContentType());
            ResponseEntity<Long> response = databaseFeignClient.upload(image);


            // making dao
            UploadedImageDAO imageDAO = new UploadedImageDAO(response.getBody());

            // giving to start image analysis
            return imageAnalysisFeignClient.startAnalysis(imageDAO);

        }catch (Exception e){
            UploadedImageDAO imageDAO = new UploadedImageDAO(-1L);
            return imageAnalysisFeignClient.startAnalysis(imageDAO);
        }
    }

    @GetMapping("/images/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable("imageId") Long imageId) {
        try{
            ResponseEntity<Image> imageById = databaseFeignClient.getImageById(imageId);
            if(imageById.getStatusCode().is2xxSuccessful()){
                Image image = imageById.getBody();
                byte[] imageBytes = image.getData();
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
            }else{
                throw  new Exception("Image Not Found With Id : "+imageId);
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.IMAGE_JPEG).body(new byte[]{});
        }
    }

}
