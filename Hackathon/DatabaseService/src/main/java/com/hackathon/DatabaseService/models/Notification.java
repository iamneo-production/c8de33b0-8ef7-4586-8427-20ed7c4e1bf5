package com.hackathon.DatabaseService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Notification {

    @AllArgsConstructor
    public enum Status {

        SUCCESSFUL,
        UNSUCCESSFUL

    }

    Status status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long reportId;

    @CreationTimestamp
    Date timeStamp;
}
