package com.graphql.gateway.service;

import com.graphql.gateway.entity.Employee;
import com.graphql.gateway.outputDTO.EmployeeOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public EmployeeOutput addNewEmployeeByDepartmentId(Long departmentId, Employee employee) {
        return null;
    }

    @Override
    public List<EmployeeOutput> getAllEmployees() {
        return List.of();
    }

    @Override
    public List<EmployeeOutput> getAllEmployeesByDepartment(Long departmentId) {
        return List.of();
    }

    @Override
    public EmployeeOutput updateEmployeeByEmployeeId(Long employeeId, Employee employee) {
        return null;
    }

    @Override
    public EmployeeOutput changeEmployeesDepartment(Long employeeId, Long newDepartmentId) {
        return null;
    }

    @Override
    public String deleteEmployeeById(Long employeeId) {
        return "";
    }

}
