package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.models.Image;
import com.hackathon.DatabaseService.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image upload(Image image) {
        Image savedImage = imageRepository.save(image);
        return savedImage;
    }

    public Image getImageById(Long id) throws Exception {
        Optional<Image> byId = imageRepository.findById(id);
        if(byId.isPresent()) return  byId.get();
        else throw new Exception("Image Not Found With Id : "+id);
    }
}
