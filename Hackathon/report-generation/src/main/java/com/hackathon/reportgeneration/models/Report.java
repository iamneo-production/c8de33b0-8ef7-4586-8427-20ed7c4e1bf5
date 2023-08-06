package com.hackathon.reportgeneration.models;

import com.hackathon.reportgeneration.utils.Conclusion;
import com.hackathon.reportgeneration.utils.Findings;
import com.hackathon.reportgeneration.utils.InterpretationDiagnosis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Report {
    Long id;

    Long imageId;

    Long analysisId;

    String imagingFindings = "";

    String interpretationDiagnosis = "";

    String conclusion = "";

    ImageAnalysis imageAnalysis;

    public Report(Long imageId, Long analysisId){
        this.imageId = imageId;
        this.analysisId = analysisId;
        this.conclusion = Conclusion.randomConclusion();
        this.imagingFindings = Findings.randomFindings();
        this.interpretationDiagnosis = InterpretationDiagnosis.randomInterpretation();
    }

    public Report(Long analysisId){
        this.imageId = -1L;
        this.analysisId = analysisId;
    }

}
