package com.keremz.emprating.evaluation.controllers;

import com.keremz.emprating.evaluation.models.Report;
import com.keremz.emprating.evaluation.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/reports/")
    public ResponseEntity<List<Report>> getReports() {
        return new ResponseEntity<>(reportService.getReports(), HttpStatus.OK);
    }

    @GetMapping(value = "/reports/", params = {"employeeId"})
    public ResponseEntity<List<Report>> getReportsByEmployee(@RequestParam String employeeId) {
        return new ResponseEntity<>(reportService.getReportsBySalesman(employeeId), HttpStatus.OK);
    }

    @PostMapping("/reports/")
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        return new ResponseEntity<>(reportService.createReport(report), HttpStatus.CREATED);
    }

    @PutMapping("/reports/{reportId}/")
    public ResponseEntity<Report> updateReport(@RequestBody Report report, @PathVariable String reportId) {
        try {
            return new ResponseEntity<>(reportService.updateReport(report, reportId), HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Report ID which will be updated, not provided" +
                    ".");
        }
    }

    @DeleteMapping("/reports/{reportId}")
    public ResponseEntity<String> deleteReport(@PathVariable String reportId) {
        try {
            return new ResponseEntity<>(reportService.deleteReport(reportId), HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}
