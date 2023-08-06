package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.models.Image;
import com.hackathon.DatabaseService.models.ImageAnalysis;
import com.hackathon.DatabaseService.repositories.ImageAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageAnalysisServiceImpl  implements  ImageAnalysisService {

    @Autowired
    ImageAnalysisRepository imageAnalysisRepository;

    @Override
    public ImageAnalysis save(ImageAnalysis imageAnalysis) {
        return imageAnalysisRepository.save(imageAnalysis);
    }

    public ImageAnalysis getImageAnalysisById(Long id) throws RuntimeException {
        Optional<ImageAnalysis> byId = imageAnalysisRepository.findById(id);
        if(byId.isPresent()) return  byId.get();
        else throw new RuntimeException("ImageAnalysis Not Found With Id : "+id);
    }
}
