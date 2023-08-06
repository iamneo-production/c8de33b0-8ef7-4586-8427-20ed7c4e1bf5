package com.hackathon.DatabaseService.repositories;

import com.hackathon.DatabaseService.models.ImageAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageAnalysisRepository extends JpaRepository<ImageAnalysis,Long> {
}
