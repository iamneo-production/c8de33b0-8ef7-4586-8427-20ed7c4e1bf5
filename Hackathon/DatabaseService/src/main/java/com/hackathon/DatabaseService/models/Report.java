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
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long imageId;

    Long analysisId;

    @CreationTimestamp
    Date timeStamp;

    @Lob
    String imagingFindings = "";

    @Lob
    String interpretationDiagnosis = "";

    @Lob
    String conclusion = "";

    @Transient
    ImageAnalysis imageAnalysis;

}
