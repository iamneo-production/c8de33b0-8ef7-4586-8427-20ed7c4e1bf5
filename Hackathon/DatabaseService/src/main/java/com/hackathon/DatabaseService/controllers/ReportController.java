package com.hackathon.DatabaseService.controllers;

import com.hackathon.DatabaseService.exceptions.ReportNotFoundException;
import com.hackathon.DatabaseService.models.ImageAnalysis;
import com.hackathon.DatabaseService.models.Report;
import com.hackathon.DatabaseService.service.ImageAnalysisService;
import com.hackathon.DatabaseService.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @Autowired
    ImageAnalysisService imageAnalysisService;

    @PostMapping("/save")
    public ResponseEntity<Report> save(@RequestBody Report report){
        Report savedReport = reportService.save(report);
        return ResponseEntity.ok(savedReport);
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<Object> getReportById(@PathVariable("reportId") Long reportId){
        try {
            Report reportById = reportService.getReportById(reportId);
            ImageAnalysis imageAnalysisById = imageAnalysisService.getImageAnalysisById(reportById.getAnalysisId());
            reportById.setImageAnalysis(imageAnalysisById);
            return ResponseEntity.ok(reportById);
        } catch (ReportNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

}
