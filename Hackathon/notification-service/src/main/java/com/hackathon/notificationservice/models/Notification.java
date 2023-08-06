package com.hackathon.notificationservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notification {

    @AllArgsConstructor
    public enum Status {

        SUCCESSFUL,
        UNSUCCESSFUL

    }

    Status status;

    Long id;

    Long reportId;

    public Notification(Status status, Long reportId) {
        this.status = status;
        this.reportId = reportId;
    }
}
