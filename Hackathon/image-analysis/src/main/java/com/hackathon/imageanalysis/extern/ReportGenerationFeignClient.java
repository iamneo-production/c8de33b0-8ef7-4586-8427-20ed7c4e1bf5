package com.hackathon.imageanalysis.extern;

import com.hackathon.imageanalysis.DAO.AnalysisDTO;
import com.hackathon.imageanalysis.DAO.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("REPORT-GENERATION-SERVICE")
public interface ReportGenerationFeignClient {

    @PostMapping("/api/reports")
    ResponseEntity<NotificationDTO> startReportGeneration(AnalysisDTO analysisDTO);

}
