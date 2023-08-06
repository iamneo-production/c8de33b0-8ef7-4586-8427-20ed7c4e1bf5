package com.hackathon.reportgeneration.controllers;

import com.hackathon.reportgeneration.DTO.AnalysisDTO;
import com.hackathon.reportgeneration.DTO.NotificationDTO;
import com.hackathon.reportgeneration.DTO.ReportDTO;
import com.hackathon.reportgeneration.exceptions.ReportNotFoundException;
import com.hackathon.reportgeneration.extern.DatabaseFeignClient;
import com.hackathon.reportgeneration.extern.NotificationFeignClient;
import com.hackathon.reportgeneration.models.ImageAnalysis;
import com.hackathon.reportgeneration.models.Report;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    DatabaseFeignClient databaseFeignClient;

    @Autowired
    NotificationFeignClient notificationFeignClient;

    @PostMapping
    public ResponseEntity<NotificationDTO> generateReport(@RequestBody AnalysisDTO analysisDTO) {
        Long analysisId = analysisDTO.getAnalysisId();

        ResponseEntity<ImageAnalysis> analysisById = databaseFeignClient.getAnalysisById(analysisId);
        ImageAnalysis imageAnalysis = analysisById.getBody();

        Report report = new Report(imageAnalysis.getId());
        if (imageAnalysis.getStatus() == ImageAnalysis.Status.SUCCESS) {
            report = new Report(imageAnalysis.getImageId(), imageAnalysis.getId());
        }

        ResponseEntity<Report> save = databaseFeignClient.save(report);
        ReportDTO.Status status = imageAnalysis.getStatus() == ImageAnalysis.Status.SUCCESS ? ReportDTO.Status.SUCCESS : ReportDTO.Status.FAILURE;
        ReportDTO reportDTO = new ReportDTO(save.getBody().getId(),status);
        return notificationFeignClient.sendNotification(reportDTO);

    }

    @GetMapping("/{reportId}")
    public ResponseEntity<?> getReportById(@PathVariable("reportId") Long reportId) {
        try {
            return databaseFeignClient.getReportById(reportId);
        } catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


}
