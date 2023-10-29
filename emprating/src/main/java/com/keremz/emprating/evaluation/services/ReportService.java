package com.keremz.emprating.evaluation.services;

import com.keremz.emprating.evaluation.models.Report;
import com.keremz.emprating.evaluation.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    public List<Report> getReportsBySalesman(String employeeId) {
        return reportRepository.findAllBySalesmanId(employeeId);
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }


    public Report updateReport(Report report, String reportId) throws RuntimeException {
        if (!reportRepository.existsById(reportId)) {
            throw new RuntimeException("Report not found");
        }
        return Report.builder()
                .id(reportId)
                .period(report.getPeriod())
                .remarks(report.getRemarks())
                .opinionSum(report.getOpinionSum())
                .salesman(report.getSalesman())
                .build();
    }

    public String deleteReport(String reportId) throws RuntimeException {
        if (reportRepository.existsById(reportId)) {
            reportRepository.deleteById(reportId);
            return "Report with ID: " + reportId + " successfully deleted";
        } else {
            throw new RuntimeException("Report with ID: " + reportId + " successfully deleted");
        }
    }
}
