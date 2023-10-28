package com.keremz.emprating.salesman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    public Salesman create(Salesman salesman) {
        if (salesmanRepository.existsByEmployeeId(salesman.employeeId)) {
            // TODO: Create custom Salesman Exceptions
            throw new RuntimeException("Fehler: Salesman already exists.");
        }
        return salesmanRepository.save(salesman);
    }

    public Salesman getSalesman(Integer employeeId) {
        if (!salesmanRepository.existsByEmployeeId(employeeId)) {
            throw new RuntimeException("Salesman with employeeId: " + employeeId + " not found.");
        }
        return salesmanRepository.findByEmployeeId(employeeId);
    }

    public void deleteSalesman(Integer employeeId) {
        if (!salesmanRepository.existsByEmployeeId(employeeId)) {
            throw new RuntimeException("Salesman with employeeId: " + employeeId + " not found.");
        }
        salesmanRepository.deleteByEmployeeId(employeeId);
    }

    public Salesman updateSalesman(Integer employeeId, Salesman salesman) throws RuntimeException {
        if (!salesmanRepository.existsByEmployeeId(employeeId)) {
            throw new RuntimeException("Fehler: Salesman with ID: " + employeeId + " not found");
        }

        Salesman foundSalesman = salesmanRepository.findByEmployeeId(employeeId);
        foundSalesman.setName(salesman.getName());
        foundSalesman.setDepartment(salesman.getDepartment());
        foundSalesman.setEmployeeId(salesman.getEmployeeId());

        return salesmanRepository.save(foundSalesman);
    }
}
