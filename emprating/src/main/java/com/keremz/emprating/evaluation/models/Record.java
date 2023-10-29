package com.keremz.emprating.evaluation.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Builder
@AllArgsConstructor
@Document("record")
public class Record {
    @Id
    String id;

    private String name;
    private Integer targetValue;
    private Integer actualValue;
    private Integer bonus;

    @DocumentReference(lazy = true)
    @NotNull(message = "Report field of Report cannot be blank")
    private Report report;
}
