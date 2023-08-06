package com.hackathon.notificationservice.extern;


import com.hackathon.notificationservice.models.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("DATABASE-SERVICE")
public interface DatabaseFeignClient {

    @PostMapping("/notification/save")
    ResponseEntity<Notification> save(Notification notification);

}