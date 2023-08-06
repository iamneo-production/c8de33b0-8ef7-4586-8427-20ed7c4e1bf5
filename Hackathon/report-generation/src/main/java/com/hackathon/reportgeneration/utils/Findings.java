package com.hackathon.reportgeneration.utils;

import java.util.List;
import java.util.Random;

public class Findings {
    private static final String[] data =  {
            "Chest X-ray shows consolidation and air bronchograms in the right lower lobe, suggestive of pneumonia.",
            "Brain MRI reveals a well-defined mass with irregular borders and perilesional edema, consistent with a brain tumor.",
            "Abdominal CT scan demonstrates a 4 cm hypoattenuating lesion in the liver's segment VI, suspicious for hepatocellular carcinoma.",
            "Lumbar spine X-ray exhibits degenerative changes, including disc space narrowing and osteophyte formation at L4-L5 and L5-S1 levels.",
            "Pelvic ultrasound shows a complex ovarian cyst with thick septations and mural nodules, concerning for malignancy."
    };

    static public String randomFindings(){
        return  data[new Random().nextInt(data.length)];
    }
}
