package com.keremz.emprating.evaluation.services;

import com.keremz.emprating.evaluation.models.Record;
import com.keremz.emprating.evaluation.repositories.RecordRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public Record createRecord(@Valid @RequestBody Record recordEntity) {
        return recordRepository.save(recordEntity);
    }

    public List<Record> getRecordsByReport(String recordId) {
        return recordRepository.findAllByReportId(recordId);
    }

    public Record getRecord(String recordId) throws RuntimeException {
        if (recordRepository.existsById(recordId)) {
            return recordRepository.findById(recordId).get();
        } else {
            throw new RuntimeException("Record with ID: " + recordId + " not found.");
        }
    }

    public Record updateRecord(Record recordEntity, String recordId) {
        Record updatedRecord = Record.builder()
                .id(recordId)
                .name(recordEntity.getName())
                .targetValue(recordEntity.getTargetValue())
                .actualValue(recordEntity.getActualValue())
                .bonus(recordEntity.getBonus())
                .report(recordEntity.getReport())
                .build();
        return recordRepository.save(updatedRecord);
    }

    public String deleteRecord(String recordId) {
        if (recordRepository.existsById(recordId)) {
            recordRepository.deleteById(recordId);
            return "A record with ID: " + " successfully deleted.";
        }
        throw new RuntimeException("A record with ID: " + recordId + " not found and couldn't deleted.");
    }
}
