package com.hackathon.DatabaseService.repositories;

import com.hackathon.DatabaseService.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
