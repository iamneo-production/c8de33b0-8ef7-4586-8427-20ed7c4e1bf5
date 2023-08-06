package com.hackathon.imageanalysis.utils;

import java.util.Random;

public class Segmentation {

    public static final String[] data = {
            "Segmenting and highlighting the brain tumor to aid in surgical planning and radiation therapy.",
            "Separating the left and right ventricles of the heart for better assessment of cardiac function.",
            "Identifying and outlining the liver lesions to monitor their growth or response to treatment.",
            "Delineating the boundaries of the prostate gland in MRI for accurate biopsy targeting.",
            "Segmenting the blood vessels in a brain CT angiogram to assess the risk of stroke."
    };

    public static String randomSegmentation() {
        return data[new Random().nextInt(data.length)];
    }

}
