package com.graphql.gateway.util;

import com.graphql.gateway.entity.Department;
import com.graphql.gateway.inputDTO.DepartmentInput;
import com.graphql.gateway.outputDTO.DepartmentOutput;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DepartmentBuilder {

    public Department buildDepartmentFromDepartmentInput(DepartmentInput input) {

        return Department.builder()
                .departmentCode(input.getDepartmentCode())
                .departmentName(input.getDepartmentName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

    }

    public DepartmentOutput buildDepartmentOutputFromDepartment(Department department) {

        return DepartmentOutput.builder()
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .build();

    }

}
