package com.keremz.emprating.salesman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    @PostMapping("/salesmen/")
    public ResponseEntity<Salesman> create(@RequestBody Salesman salesman) {
        Salesman s = Salesman.builder()
                .employeeId(salesman.getEmployeeId())
                .name(salesman.getName())
                .department(salesman.getDepartment())
                .build();
        return new ResponseEntity<>(salesmanService.create(s), HttpStatus.CREATED);
    }

    @GetMapping("/salesmen/{employeeId}/")
    public ResponseEntity<Salesman> getSalesman(@PathVariable Integer employeeId) {
        return new ResponseEntity<>(salesmanService.getSalesman(employeeId), HttpStatus.OK);
    }

    @DeleteMapping("/salesmen/{employeeId}/")
    public ResponseEntity<String> deleteSalesman(@PathVariable Integer employeeId) {
        salesmanService.deleteSalesman(employeeId);
        return new ResponseEntity<>("Salesman with employeeID: " + employeeId + " successfully deleted", HttpStatus.OK);
    }

    @PutMapping("/salesmen/{employeeId}/")
    public ResponseEntity<Salesman> updateSalesman(@PathVariable Integer employeeId, @RequestBody Salesman salesman) {
        return new ResponseEntity<>(salesmanService.updateSalesman(employeeId, salesman), HttpStatus.OK);
    }

}
