package com.hackathon.imageanalysis.utils;

import java.util.Random;

public class ImageAcquisition {

    private final static String[] data = {
            "Obtaining an X-ray image of the chest to check for pneumonia or lung infections.",
            "Getting an MRI scan of the knee to evaluate ligament tears or cartilage damage.",
            "Performing a CT scan of the abdomen to look for kidney stones or abdominal tumors.",
            "Taking an ultrasound image of the uterus during pregnancy to monitor fetal development.",
            "Capturing a PET scan image to identify areas of high metabolic activity in the body, which can indicate cancer or infections."
    };

    public static String  randomImageAcquisition(){
        return data[ new Random().nextInt(data.length)];
    }

}
