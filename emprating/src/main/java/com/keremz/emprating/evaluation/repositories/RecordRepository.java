package com.keremz.emprating.evaluation.repositories;

import com.keremz.emprating.evaluation.models.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {
}
