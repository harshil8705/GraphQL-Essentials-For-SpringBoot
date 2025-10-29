package com.graphql.gateway.controller;

import com.graphql.gateway.entity.Employee;
import com.graphql.gateway.inputDTO.EmployeeInput;
import com.graphql.gateway.outputDTO.EmployeeOutput;
import com.graphql.gateway.service.EmployeeServiceImpl;
import com.graphql.gateway.util.EmployeeBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    private final EmployeeBuilder employeeBuilder;

    @MutationMapping
    public EmployeeOutput addNewEmployeeByDepartmentId(@Argument Long departmentId, @Argument("employeeInput") EmployeeInput employeeInput) {

        Employee employee = employeeBuilder.buildEmployeeFromEmployeeInput(employeeInput);

        return employeeService.addNewEmployeeByDepartmentId(departmentId, employee);

    }

    @QueryMapping
    public List<EmployeeOutput> getAllEmployees() {

        return employeeService.getAllEmployees();

    }

    @QueryMapping
    public List<EmployeeOutput> getAllEmployeesByDepartment(@Argument Long departmentId) {

        return employeeService.getAllEmployeesByDepartment(departmentId);

    }

    @MutationMapping
    public EmployeeOutput updateEmployeeByEmployeeId(@Argument Long employeeId, @Argument("employeeInput") EmployeeInput employeeInput) {

        Employee employee = employeeBuilder.buildEmployeeFromEmployeeInput(employeeInput);

        return employeeService.updateEmployeeByEmployeeId(employeeId, employee);

    }

    @MutationMapping
    public EmployeeOutput changeEmployeesDepartment(@Argument Long employeeId, @Argument Long newDepartmentId) {

        return employeeService.changeEmployeesDepartment(employeeId, newDepartmentId);

    }

    @MutationMapping
    public String deleteEmployeeById(@Argument Long employeeId) {

        return employeeService.deleteEmployeeById(employeeId);

    }

}
