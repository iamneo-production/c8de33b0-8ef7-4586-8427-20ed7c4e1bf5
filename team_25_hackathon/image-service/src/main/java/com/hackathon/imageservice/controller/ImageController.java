package com.hackathon.imageservice.controller;

import com.hackathon.imageservice.extern.DatabaseFeignClient;
import com.hackathon.imageservice.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    DatabaseFeignClient databaseFeignClient;

    @PostMapping("/upload")
    public ResponseEntity<Long> uploadImage(@RequestParam("file")MultipartFile file){
        try {
            Image image = new Image(file.getBytes(), file.getOriginalFilename(), file.getContentType());
            ResponseEntity<Long> response = databaseFeignClient.upload(image);
            return response;
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

}
