package com.hackathon.reportgeneration.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageAnalysis {

    @AllArgsConstructor
    public enum Status {SUCCESS,FAILURE};

    Status status;

    Long id;

    Date timeStamp;

    Long imageId;

    String imageAcquisition;

    String segmentation;

    String quantitativeAnalysis;

    String cad; // Computer-Aided Diagnosis

    String visualization;

}
