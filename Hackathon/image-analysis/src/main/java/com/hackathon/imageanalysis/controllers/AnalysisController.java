package com.hackathon.imageanalysis.controllers;

import com.hackathon.imageanalysis.DAO.AnalysisDTO;
import com.hackathon.imageanalysis.DAO.NotificationDTO;
import com.hackathon.imageanalysis.DAO.UploadedImageDAO;
import com.hackathon.imageanalysis.extern.DatabaseFeignClient;
import com.hackathon.imageanalysis.extern.ReportGenerationFeignClient;
import com.hackathon.imageanalysis.models.Image;
import com.hackathon.imageanalysis.models.ImageAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/analyze")
public class AnalysisController {

    @Autowired
    DatabaseFeignClient databaseFeignClient;

    @Autowired
    ReportGenerationFeignClient reportGenerationFeignClient;

    @PostMapping
    public ResponseEntity<NotificationDTO> analyse(@RequestBody UploadedImageDAO imageDAO) {
        ImageAnalysis imageAnalysis = new ImageAnalysis(ImageAnalysis.Status.FAILURE);
        if (imageDAO.getId() != -1) {
            // getting image data from database service
            ResponseEntity<Image> response = databaseFeignClient.getImageById(imageDAO.getId());
            if (response.getStatusCode().is2xxSuccessful()) {
                Image image = response.getBody();
                // making analysis object
                imageAnalysis = new ImageAnalysis(imageDAO.getId(), ImageAnalysis.Status.SUCCESS);
            }
        }

        // saving analysis object to database
        ResponseEntity<ImageAnalysis> imageAnalysisResponseEntity = databaseFeignClient.saveAnalysis(imageAnalysis);
        ImageAnalysis imageAnalysis1 = imageAnalysisResponseEntity.getBody();

        // sending dto to start report generation process
        AnalysisDTO analysisDTO = new AnalysisDTO(imageAnalysis1.getId());
        return reportGenerationFeignClient.startReportGeneration(analysisDTO);
    }

    @GetMapping("/{analysis_id}")
    public ResponseEntity<?> getAnalysisById(@PathVariable("analysis_id") Long analysis_id){
        try {
            return databaseFeignClient.getAnalysisById(analysis_id);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

}
