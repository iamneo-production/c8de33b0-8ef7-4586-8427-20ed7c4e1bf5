package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.exceptions.ReportNotFoundException;
import com.hackathon.DatabaseService.models.Notification;

public interface NotificationService {

    Notification save(Notification notification);

}
