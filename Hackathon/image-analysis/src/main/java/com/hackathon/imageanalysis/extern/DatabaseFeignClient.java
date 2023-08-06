package com.hackathon.imageanalysis.extern;

import com.hackathon.imageanalysis.models.Image;
import com.hackathon.imageanalysis.models.ImageAnalysis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("DATABASE-SERVICE")
public interface DatabaseFeignClient {
    @GetMapping("/image/{imageId}")
    ResponseEntity<Image> getImageById(@PathVariable("imageId") Long imageId);

    @PostMapping("/analysis/save")
    ResponseEntity<ImageAnalysis> saveAnalysis(ImageAnalysis imageAnalysis);

    @GetMapping("/analysis/{analysisId}")
    ResponseEntity<ImageAnalysis> getAnalysisById(@PathVariable("analysisId") Long analysisId);

}

