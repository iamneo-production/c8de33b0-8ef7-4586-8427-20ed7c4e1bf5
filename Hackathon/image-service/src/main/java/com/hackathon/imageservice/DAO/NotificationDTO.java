package com.hackathon.imageservice.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDTO {

    String status;

    Long reportId;

    Long notificationId;

    Date timeStamp;

}
