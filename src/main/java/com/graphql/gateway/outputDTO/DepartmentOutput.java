package com.graphql.gateway.outputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentOutput {

    private Long departmentId;
    private String departmentName;
    private String departmentCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
