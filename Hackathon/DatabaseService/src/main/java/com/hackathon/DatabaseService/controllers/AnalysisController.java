package com.hackathon.DatabaseService.controllers;

import com.hackathon.DatabaseService.models.ImageAnalysis;
import com.hackathon.DatabaseService.service.ImageAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    ImageAnalysisService imageAnalysisService;

    @PostMapping("/save")
    public ImageAnalysis saveAnalysis(@RequestBody ImageAnalysis imageAnalysis){
        return imageAnalysisService.save(imageAnalysis);
    }

    @GetMapping("/{analysisId}")
    public ResponseEntity<ImageAnalysis> getAnalysisById(@PathVariable("analysisId") Long analysisId){
        try {
            ImageAnalysis imageAnalysisById = imageAnalysisService.getImageAnalysisById(analysisId);
            return ResponseEntity.ok(imageAnalysisById);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
