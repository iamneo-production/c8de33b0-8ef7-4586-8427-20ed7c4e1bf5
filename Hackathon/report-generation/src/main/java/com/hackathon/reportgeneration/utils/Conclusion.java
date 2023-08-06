package com.hackathon.reportgeneration.utils;

import java.util.Random;

public class Conclusion {
    private static final String[] data = {
            "Adequate hydration and appropriate antibiotics are prescribed for pneumonia treatment.",
            "Surgical resection and further evaluation by an oncologist are recommended for the brain tumor.",
            "A liver biopsy is recommended for definitive characterization of the hepatic lesion.",
            "Symptomatic management is advised for age-related osteoarthritis in the lumbar spine.",
            "Prompt evaluation by a gynecologic oncologist is required for definitive diagnosis and management of the complex ovarian cyst."
    };

    public static String randomConclusion(){
        return data[new Random().nextInt(data.length)];
    }
}
