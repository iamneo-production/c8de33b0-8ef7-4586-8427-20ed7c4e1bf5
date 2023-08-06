package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.models.Image;

public interface ImageService {
    Image upload(Image image);

    Image getImageById(Long id) throws Exception;
}
