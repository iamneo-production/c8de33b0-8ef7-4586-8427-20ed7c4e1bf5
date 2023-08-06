package com.hackathon.reportgeneration.utils;

import java.util.List;
import java.util.Random;

public class InterpretationDiagnosis {

    static final private String[] data = {
            "The chest X-ray findings are consistent with a community-acquired pneumonia. Antibiotic therapy is recommended.",
            "Based on the MRI results, the brain tumor is likely a grade II astrocytoma. A neurosurgical consultation is advised.",
            "The CT scan findings suggest a probable hepatocellular carcinoma. A liver biopsy is recommended for definitive diagnosis.",
            "The lumbar spine X-ray indicates moderate degenerative disc disease. Physical therapy and analgesics are suggested for pain relief.",
            "The pelvic ultrasound findings raise concern for a malignant ovarian neoplasm. A referral to a gynecologic oncologist is advised."
    };

    static public String randomInterpretation(){
        return  data[new Random().nextInt(data.length)];
    }

}
