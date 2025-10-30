package com.graphql.gateway.util;

import com.graphql.gateway.entity.Employee;
import com.graphql.gateway.inputDTO.EmployeeInput;
import com.graphql.gateway.outputDTO.EmployeeOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeBuilder {

    private final DepartmentBuilder departmentBuilder;

    public Employee buildEmployeeFromEmployeeInput(EmployeeInput input) {

        return Employee.builder()
                .email(input.getEmail())
                .position(input.getPosition())
                .salary(input.getSalary())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .phoneNumber(input.getPhoneNumber())
                .build();

    }

    public EmployeeOutput buildEmployeeOutputFromEmployee(Employee employee) {

        return EmployeeOutput.builder()
                .employeeId(employee.getEmployeeId())
                .email(employee.getEmail())
                .position(employee.getPosition())
                .salary(employee.getSalary())
                .phoneNumber(employee.getPhoneNumber())
                .lastName(employee.getLastName())
                .firstName(employee.getFirstName())
                .department(departmentBuilder.buildDepartmentOutputFromDepartment(employee.getDepartment()))
                .build();

    }

}
