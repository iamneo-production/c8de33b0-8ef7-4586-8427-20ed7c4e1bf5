package com.hackathon.DatabaseService.service;

import com.hackathon.DatabaseService.exceptions.ReportNotFoundException;
import com.hackathon.DatabaseService.models.Report;

public interface ReportService {
    Report save(Report report);

    Report getReportById(Long id) throws ReportNotFoundException;
}
