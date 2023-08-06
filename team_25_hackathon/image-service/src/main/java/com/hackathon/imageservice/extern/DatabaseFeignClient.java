package com.hackathon.imageservice.extern;

import com.hackathon.imageservice.models.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("DATABASE-SERVICE")
public interface DatabaseFeignClient {
    @PostMapping("/upload/image")
    ResponseEntity<Long> upload(Image image);

}
