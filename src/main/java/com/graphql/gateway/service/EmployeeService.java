package com.graphql.gateway.service;

import com.graphql.gateway.entity.Employee;
import com.graphql.gateway.outputDTO.EmployeeOutput;

import java.util.List;

public interface EmployeeService {

    EmployeeOutput addNewEmployeeByDepartmentId(Long departmentId, Employee employee);

    List<EmployeeOutput> getAllEmployees();

    List<EmployeeOutput> getAllEmployeesByDepartment(Long departmentId);

    EmployeeOutput updateEmployeeByEmployeeId(Long employeeId, Employee employee);

    EmployeeOutput changeEmployeesDepartment(Long employeeId, Long newDepartmentId);

    String deleteEmployeeById(Long employeeId);

}
