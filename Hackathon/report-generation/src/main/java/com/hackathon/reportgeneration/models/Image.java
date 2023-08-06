package com.hackathon.reportgeneration.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    Long id;

    byte[] data;
    String filename;

    String fileType;

    Date timestamp;

}
