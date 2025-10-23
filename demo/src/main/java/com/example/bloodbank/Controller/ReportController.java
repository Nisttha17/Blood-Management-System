package com.example.bloodbank.Controller;

import com.example.bloodbank.entity.Report;
import com.example.bloodbank.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Create a new report
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report savedReport = reportService.saveReport(report);
        return ResponseEntity.ok(savedReport);
    }

    // Get all reports
    @GetMapping
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    // Get report by ID
    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        return reportService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.ok("Report deleted successfully");
    }

    // Update a report
    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestBody Report reportDetails) {
        return reportService.getReportById(id)
                .map(report -> {
                    report.setDonor(reportDetails.getDonor());
                    report.setBloodCamp(reportDetails.getBloodCamp());
                    report.setHealthStatus(reportDetails.getHealthStatus());
                    report.setBloodTestResult(reportDetails.getBloodTestResult());
                    report.setDonationDate(reportDetails.getDonationDate());
                    report.setRemarks(reportDetails.getRemarks());
                    Report updatedReport = reportService.saveReport(report);
                    return ResponseEntity.ok(updatedReport);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
