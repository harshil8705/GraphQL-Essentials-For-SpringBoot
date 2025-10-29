package com.graphql.gateway.controller;

import com.graphql.gateway.entity.Department;
import com.graphql.gateway.inputDTO.DepartmentInput;
import com.graphql.gateway.outputDTO.DepartmentOutput;
import com.graphql.gateway.service.DepartmentServiceImpl;
import com.graphql.gateway.util.DepartmentBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;
    private final DepartmentBuilder departmentBuilder;

    @MutationMapping
    public DepartmentOutput addNewDepartment(@Argument("departmentInput") DepartmentInput departmentInput) {

        Department department = departmentBuilder.buildDepartmentFromDepartmentInput(departmentInput);

        return departmentService.addNewDepartment(department);

    }

    @QueryMapping
    public List<DepartmentOutput> getAllDepartment() {

        return departmentService.getAllDepartment();

    }

    @QueryMapping
    public DepartmentOutput getDepartmentById(@Argument Long departmentId) {

        return departmentService.getDepartmentById(departmentId);

    }

    @MutationMapping
    public DepartmentOutput updateDepartmentById(@Argument Long departmentId, @Argument("departmentInput") DepartmentInput departmentInput) {

        Department department = departmentBuilder.buildDepartmentFromDepartmentInput(departmentInput);

        return departmentService.updateDepartmentById(departmentId, department);

    }

    @MutationMapping
    public String deleteDepartmentById(@Argument Long departmentId) {

        return departmentService.deleteDepartmentById(departmentId);

    }

}
