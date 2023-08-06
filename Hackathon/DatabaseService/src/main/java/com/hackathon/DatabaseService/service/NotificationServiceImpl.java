package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.exceptions.ReportNotFoundException;
import com.hackathon.DatabaseService.models.Notification;
import com.hackathon.DatabaseService.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public Notification save(Notification notification){
        return notificationRepository.save(notification);
    }



}
