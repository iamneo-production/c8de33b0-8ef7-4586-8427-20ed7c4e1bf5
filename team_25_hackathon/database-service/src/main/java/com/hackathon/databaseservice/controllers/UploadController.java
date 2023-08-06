package com.hackathon.databaseservice.controllers;

import com.hackathon.databaseservice.models.Image;
import com.hackathon.databaseservice.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/image")
    public ResponseEntity<Long> uploadImage(@RequestBody Image image){
        Image savedImage = imageRepository.save(image);
        return ResponseEntity.ok(savedImage.getId());
    }

}
