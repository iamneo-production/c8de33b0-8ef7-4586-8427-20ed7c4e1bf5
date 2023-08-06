package com.hackathon.reportgeneration.extern;

import com.hackathon.reportgeneration.DTO.NotificationDTO;
import com.hackathon.reportgeneration.DTO.ReportDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("NOTIFICATION-SERVICE")
public interface NotificationFeignClient {

    @PostMapping("/api/notifications")
    public ResponseEntity<NotificationDTO> sendNotification(ReportDTO reportDTO);

}
