package com.hackathon.databaseservice.service;

import com.hackathon.databaseservice.models.Image;
import com.hackathon.databaseservice.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image upload(Image image) {
        Image savedImage = imageRepository.save(image);
        return savedImage;
    }
}
