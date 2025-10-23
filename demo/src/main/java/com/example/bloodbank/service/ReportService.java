package com.example.bloodbank.service;

import com.example.bloodbank.entity.Report;
import com.example.bloodbank.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // Save or update a report
    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    // Get all reports
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // Get report by ID
    public Optional<Report> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    // Delete report by ID
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
