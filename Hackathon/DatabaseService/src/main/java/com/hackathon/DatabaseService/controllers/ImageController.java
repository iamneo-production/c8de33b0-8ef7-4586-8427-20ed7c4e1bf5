package com.hackathon.DatabaseService.controllers;

import com.hackathon.DatabaseService.models.Image;
import com.hackathon.DatabaseService.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Long> uploadImage(@RequestBody Image image){
        Image savedImage = imageService.upload(image);
        return ResponseEntity.ok(savedImage.getId());
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<Image> getImageById(@PathVariable("imageId") Long imageId){
        try {
            Image imageById = imageService.getImageById(imageId);
            return ResponseEntity.ok(imageById);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
