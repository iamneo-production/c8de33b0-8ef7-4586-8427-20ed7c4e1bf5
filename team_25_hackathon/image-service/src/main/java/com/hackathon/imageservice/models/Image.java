package com.hackathon.imageservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    byte[] data;
    String filename;

    String fileType;

}
