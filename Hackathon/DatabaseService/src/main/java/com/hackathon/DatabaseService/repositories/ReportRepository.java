package com.hackathon.DatabaseService.repositories;

import com.hackathon.DatabaseService.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
}
