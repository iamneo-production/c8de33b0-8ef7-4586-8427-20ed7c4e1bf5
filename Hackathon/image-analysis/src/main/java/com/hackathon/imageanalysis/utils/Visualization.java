package com.hackathon.imageanalysis.utils;

import java.util.Random;

public class Visualization {

    private static final String[] data =  {
            "Displaying a 3D rendering of the spine from a CT scan to aid in surgical planning for spinal fusion.",
            "Presenting a color-coded map of brain activation from a functional MRI (fMRI) during a cognitive task.",
            "Showing a side-by-side comparison of a patient's current and previous X-rays to assess the progression of scoliosis.",
            "Visualizing the blood flow patterns in the heart using color Doppler echocardiography.",
            "Creating a composite image of a tumor's growth over time from sequential MRI scans to monitor treatment efficacy."
    };

    public static String randomVisualization() {
        return data[new Random().nextInt(data.length)];
    }
}
