package com.graphql.gateway.service;

import com.graphql.gateway.entity.Department;
import com.graphql.gateway.entity.Employee;
import com.graphql.gateway.outputDTO.EmployeeOutput;
import com.graphql.gateway.repository.DepartmentRepository;
import com.graphql.gateway.repository.EmployeeRepository;
import com.graphql.gateway.util.EmployeeBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeBuilder employeeBuilder;

    @Override
    public EmployeeOutput addNewEmployeeByDepartmentId(Long departmentId, Employee employee) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException("No department exists with departmentId: " + departmentId));

        Employee newEmployee = Employee.builder()
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .lastName(employee.getLastName())
                .firstName(employee.getFirstName())
                .salary(employee.getSalary())
                .position(employee.getPosition())
                .department(department)
                .build();
        department.getEmployees().add(newEmployee);

//        departmentRepository.save(department);
        newEmployee = employeeRepository.save(newEmployee);

        return employeeBuilder.buildEmployeeOutputFromEmployee(newEmployee);

    }

    @Override
    public List<EmployeeOutput> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new RuntimeException("No Employee exists currently!!");
        }

        return employees.stream()
                .map(employeeBuilder::buildEmployeeOutputFromEmployee)
                .toList();

    }

    @Override
    public List<EmployeeOutput> getAllEmployeesByDepartment(Long departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException("No Department exists with departmentId: " + departmentId));

        List<Employee> employees = department.getEmployees();

        if (employees.isEmpty()) {
            throw new RuntimeException("No Employees exists in the Department: " + department.getDepartmentName());
        }

        return employees.stream()
                .map(employeeBuilder::buildEmployeeOutputFromEmployee)
                .toList();

    }

    @Override
    public EmployeeOutput updateEmployeeByEmployeeId(Long employeeId, Employee employee) {

        Employee updatedEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("No Employee exists with employeeId: " + employeeId));

        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setSalary(employee.getSalary());
        updatedEmployee.setPosition(employee.getPosition());
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setPhoneNumber(employee.getPhoneNumber());

        updatedEmployee = employeeRepository.save(updatedEmployee);

        return employeeBuilder.buildEmployeeOutputFromEmployee(updatedEmployee);

    }

    @Override
    @Transactional
    public EmployeeOutput changeEmployeesDepartment(Long employeeId, Long newDepartmentId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("No Employee exists with employeeId: " + employeeId));

        Department sourceDepartment = employee.getDepartment();

        Department destinationDepartment = departmentRepository.findById(newDepartmentId)
                .orElseThrow(() ->
                        new RuntimeException("No Department exists with departmentId: " + newDepartmentId));

        if (destinationDepartment.getDepartmentId().equals(sourceDepartment.getDepartmentId())) {
            throw new RuntimeException("Source and Destination Departments can't be same!!");
        }

        employee.setDepartment(destinationDepartment);

        employee = employeeRepository.save(employee);

        return employeeBuilder.buildEmployeeOutputFromEmployee(employee);

    }

    @Override
    public String deleteEmployeeById(Long employeeId) {

        Employee employeeToDelete = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("No Employee exists with employeeId: " + employeeId));

        employeeRepository.delete(employeeToDelete);

        return "Employee with employeeId: " + employeeId + " deleted Successfully!!";

    }

}
