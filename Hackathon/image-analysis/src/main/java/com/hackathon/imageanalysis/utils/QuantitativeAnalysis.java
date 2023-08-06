package com.hackathon.imageanalysis.utils;

import java.util.Random;

public class QuantitativeAnalysis {

    private static final String[] data = {
            "Measuring the size of a thyroid nodule on ultrasound to determine if a biopsy is necessary.",
            "Calculating the volume of a lung tumor on a CT scan to track treatment response.",
            "Assessing bone mineral density on a DXA scan to diagnose osteoporosis.",
            "Quantifying the degree of liver fat infiltration in MRI to diagnose fatty liver disease.",
            "Analyzing the flow velocity in a carotid artery using Doppler ultrasound to assess the risk of stroke."
    };

    public static String randomQuantitativeAnalysis() {
        return data[new Random().nextInt(data.length)];
    }

}
