package com.hackathon.imageanalysis.utils;

import java.util.Random;

public class CAD {

    private static final String[] data = {
            "CAD system assisting in the detection of early-stage breast cancer in mammograms.",
            "CAD algorithm flagging potential brain hemorrhages in head CT scans.",
            "CAD software highlighting suspicious lung nodules on chest X-rays to aid in early detection of lung cancer.",
            "Using CAD to identify signs of osteoarthritis in knee X-rays for prompt intervention.",
            "CAD tool assisting in the diagnosis of Alzheimer's disease by detecting brain atrophy on MRI scans."
    };

    public static String randomCAD() {
        return data[new Random().nextInt(data.length)];
    }
}
