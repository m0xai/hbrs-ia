package com.keremz.emprating.evaluation.models;

import com.keremz.emprating.evaluation.enums.OpinionSum;
import com.keremz.emprating.salesman.Salesman;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Document("report")
public class Report {
    @Id
    String id;

    Date period;
    OpinionSum opinionSum;
    String remarks;

    @DocumentReference(lazy = true)
    @NotNull(message = "Employee field of Report cannot be blank")
    private Salesman salesman;
}

