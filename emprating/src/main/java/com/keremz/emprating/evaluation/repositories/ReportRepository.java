package com.keremz.emprating.evaluation.repositories;

import com.keremz.emprating.evaluation.models.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
    List<Report> findAllBySalesmanId(String salesmanId);
}
