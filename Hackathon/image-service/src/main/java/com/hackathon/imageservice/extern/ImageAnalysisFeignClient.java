package com.hackathon.imageservice.extern;

import com.hackathon.imageservice.DAO.NotificationDTO;
import com.hackathon.imageservice.DAO.UploadedImageDAO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("IMAGE-ANALYSIS-SERVICE")
public interface ImageAnalysisFeignClient {

    @PostMapping("/api/analyze")
    ResponseEntity<NotificationDTO> startAnalysis(UploadedImageDAO imageDAO);

}
