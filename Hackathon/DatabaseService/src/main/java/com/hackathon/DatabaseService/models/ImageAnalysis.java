package com.hackathon.DatabaseService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ImageAnalysis {

    @AllArgsConstructor
    @Table(name = "analysisStatusTable")
    public enum Status {SUCCESS,FAILURE};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    Status status;

    @CreationTimestamp
    Date timeStamp;

    Long imageId;

    String imageAcquisition = "";

    String segmentation = "";

    String quantitativeAnalysis = "";

    String cad = ""; // Computer-Aided Diagnosis

    String visualization = "";

}
