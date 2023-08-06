package com.hackathon.imageanalysis.models;

import com.hackathon.imageanalysis.utils.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageAnalysis {

    @AllArgsConstructor
    public enum Status {SUCCESS,FAILURE};

    Long id;

    Long imageId;

    String imageAcquisition = "";

    String segmentation = "";

    String quantitativeAnalysis = "";

    String cad = ""; // Computer-Aided Diagnosis

    String visualization = "";

    Status status;

    public ImageAnalysis(Long imageId,Status status) {
        this.imageId = imageId;
        this.status = status;
        this.imageAcquisition = ImageAcquisition.randomImageAcquisition();
        this.segmentation = Segmentation.randomSegmentation();
        this.quantitativeAnalysis = QuantitativeAnalysis.randomQuantitativeAnalysis();
        this.cad = CAD.randomCAD(); // Computer-Aided Diagnosis
        this.visualization = Visualization.randomVisualization();
    }

    public ImageAnalysis(Status status) {
        this.imageId = -1L;
        this.status = status;
    }
}
