package com.hackathon.DatabaseService.controllers;

import com.hackathon.DatabaseService.models.Notification;
import com.hackathon.DatabaseService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/save")
    public ResponseEntity<Notification> save(@RequestBody Notification notification){
        return ResponseEntity.ok(notificationService.save(notification));
    }


}
