package com.keremz.emprating.evaluation.repositories;

import com.keremz.emprating.evaluation.models.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {
    List<Record> findAllByReportId(String reportId);
}
