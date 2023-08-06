package com.hackathon.reportgeneration.extern;

import com.hackathon.reportgeneration.models.Image;
import com.hackathon.reportgeneration.models.ImageAnalysis;
import com.hackathon.reportgeneration.models.Report;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("DATABASE-SERVICE")
public interface DatabaseFeignClient {
    @GetMapping("/image/{imageId}")
    ResponseEntity<Image> getImageById(@PathVariable("imageId") Long imageId);

    @GetMapping("/analysis/{analysisId}")
    ResponseEntity<ImageAnalysis> getAnalysisById(@PathVariable("analysisId") Long imageAnalysisId);

    @PostMapping("/report/save")
    ResponseEntity<Report> save(Report report);

    @GetMapping("/report/{reportId}")
    ResponseEntity<?> getReportById(@PathVariable("reportId") Long reportId);

}