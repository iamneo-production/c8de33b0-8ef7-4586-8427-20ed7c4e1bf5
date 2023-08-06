package com.hackathon.notificationservice.controllers;

import com.hackathon.notificationservice.DTO.NotificationDTO;
import com.hackathon.notificationservice.DTO.ReportDTO;
import com.hackathon.notificationservice.extern.DatabaseFeignClient;
import com.hackathon.notificationservice.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    DatabaseFeignClient databaseFeignClient;

    @PostMapping
    public ResponseEntity<NotificationDTO> sendNotification(@RequestBody ReportDTO reportDTO) {
        Notification.Status status = reportDTO.getStatus() == ReportDTO.Status.SUCCESS ? Notification.Status.SUCCESSFUL : Notification.Status.UNSUCCESSFUL;
        Notification notification = new Notification(status, reportDTO.getReportId());

        ResponseEntity<Notification> response = databaseFeignClient.save(notification);
        Notification savedNotification = response.getBody();

        NotificationDTO dto = new NotificationDTO(savedNotification.getStatus().toString(), savedNotification.getReportId(), savedNotification.getId(), new Date());
        return ResponseEntity.ok(dto);
    }

}
