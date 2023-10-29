package com.keremz.emprating.evaluation.controllers;

import com.keremz.emprating.evaluation.models.Record;
import com.keremz.emprating.evaluation.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping(value = "/records/", params = {"reportId"})
    public ResponseEntity<List<Record>> getRecordsByReport(@RequestParam String reportId) {
        try {
            return new ResponseEntity<>(recordService.getRecordsByReport(reportId), HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Cannot find records of report with ID: " + reportId + " in our system.");
        }
    }

    @GetMapping("/records/{recordId}/")
    public ResponseEntity<Record> getRecord(@PathVariable String recordId) {
        try {
            return new ResponseEntity<>(recordService.getRecord(recordId), HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/records/")
    public ResponseEntity<Record> createRecord(@RequestBody Record recordEntity) {
        return new ResponseEntity<>(recordService.createRecord(recordEntity), HttpStatus.CREATED);
    }

    @PutMapping("/records/{recordId}/")
    public ResponseEntity<Record> updateRecord(@RequestBody Record recordEntity, @PathVariable String recordId) {
        try {
            return new ResponseEntity<>(recordService.updateRecord(recordEntity, recordId), HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "An error occured while trying to update Record" +
                    " entity.");
        }
    }

    @DeleteMapping("/records/{recordId}/")
    public ResponseEntity<String> deleteRecord(@PathVariable String recordId) {
        try {
            return new ResponseEntity<>(recordService.deleteRecord(recordId), HttpStatus.OK);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}
