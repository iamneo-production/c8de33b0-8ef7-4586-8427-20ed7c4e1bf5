package com.hackathon.imageservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    byte[] data;
    String filename;

    String fileType;

}
