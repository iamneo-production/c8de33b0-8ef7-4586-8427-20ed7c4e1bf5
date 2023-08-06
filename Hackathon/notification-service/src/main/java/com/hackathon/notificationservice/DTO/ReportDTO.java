package com.hackathon.notificationservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportDTO {

    @AllArgsConstructor
    public enum Status {SUCCESS,FAILURE};

    Long reportId;

    Status status;

}
