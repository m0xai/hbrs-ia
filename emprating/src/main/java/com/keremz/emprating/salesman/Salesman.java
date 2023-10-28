package com.keremz.emprating.salesman;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document("salesman")
public class Salesman {
    @Id
    String id;
    @Indexed(unique=true)
    Integer employeeId;
    String name;
    String department;
}
