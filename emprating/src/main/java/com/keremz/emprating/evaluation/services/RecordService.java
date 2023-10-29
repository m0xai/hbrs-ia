package com.keremz.emprating.evaluation.services;

import com.keremz.emprating.evaluation.models.Record;
import com.keremz.emprating.evaluation.repositories.RecordRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RecordController {
    @Autowired
    private RecordRepository recordRepository;

    public Record createRecord(@Valid @RequestBody Record record) {
        return recordRepository.save(record);
    }
}
