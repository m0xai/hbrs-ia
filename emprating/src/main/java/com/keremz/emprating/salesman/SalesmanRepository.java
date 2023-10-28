package com.keremz.emprating.salesman;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesmanRepository extends MongoRepository<Salesman, Integer> {
    Salesman findByEmployeeId(Integer employeeId);
    boolean existsByEmployeeId(Integer employeeId);
    Integer deleteByEmployeeId(Integer employeeId);
}
