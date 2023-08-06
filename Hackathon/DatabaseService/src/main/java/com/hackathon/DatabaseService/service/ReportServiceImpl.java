package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.exceptions.ReportNotFoundException;
import com.hackathon.DatabaseService.models.Notification;
import com.hackathon.DatabaseService.models.Report;
import com.hackathon.DatabaseService.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    public Report save(Report report){
        return reportRepository.save(report);
    }

    public Report getReportById(Long id) throws ReportNotFoundException {
        Optional<Report> byId = reportRepository.findById(id);
        return  byId.orElseThrow(() -> new ReportNotFoundException(id) );
    }

}
