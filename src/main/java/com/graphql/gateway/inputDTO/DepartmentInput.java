package com.graphql.gateway.inputDTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentInput {

    private String departmentName;
    private String departmentCode;

}
