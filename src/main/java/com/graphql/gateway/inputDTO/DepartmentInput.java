package com.graphql.gateway.inputDTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentInput {

    private String departmentName;
    private String departmentCode;

}
