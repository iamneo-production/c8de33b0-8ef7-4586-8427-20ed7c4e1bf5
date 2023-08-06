package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.models.ImageAnalysis;

public interface ImageAnalysisService {

    ImageAnalysis save(ImageAnalysis imageAnalysis);
    ImageAnalysis getImageAnalysisById(Long id) throws RuntimeException;
}
