package com.graphql.gateway.service;

import com.graphql.gateway.entity.Department;
import com.graphql.gateway.outputDTO.DepartmentOutput;
import com.graphql.gateway.repository.DepartmentRepository;
import com.graphql.gateway.util.DepartmentBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    private final DepartmentBuilder departmentBuilder;

    @Override
    public DepartmentOutput addNewDepartment(Department department) {

        Department newDepartment = Department.builder()
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .employees(new ArrayList<>())
                .build();

        newDepartment = departmentRepository.save(newDepartment);

        return departmentBuilder.buildDepartmentOutputFromDepartment(newDepartment);

    }

    @Override
    public List<DepartmentOutput> getAllDepartment() {

        List<Department> departments = departmentRepository.findAll();

        if (departments.isEmpty()) {
            throw new RuntimeException("No Department exists currently!!");
        }

        return departments.stream()
                .map(departmentBuilder::buildDepartmentOutputFromDepartment)
                .toList();

    }

    @Override
    public DepartmentOutput getDepartmentById(Long departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException("No department exists with departmentId: " + departmentId));

        return departmentBuilder.buildDepartmentOutputFromDepartment(department);

    }

    @Override
    public DepartmentOutput updateDepartmentById(Long departmentId, Department department) {

        Department updatedDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException("No department exists with departmentId: " + departmentId));

        updatedDepartment.setDepartmentCode(department.getDepartmentCode());
        updatedDepartment.setDepartmentName(department.getDepartmentName());
        updatedDepartment.setUpdatedAt(LocalDateTime.now());

        updatedDepartment = departmentRepository.save(updatedDepartment);

        return departmentBuilder.buildDepartmentOutputFromDepartment(updatedDepartment);

    }

    @Override
    public String deleteDepartmentById(Long departmentId) {

        Department departmentToDelete = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new RuntimeException("No department exists with departmentId: " + departmentId));

        departmentRepository.delete(departmentToDelete);

        return "Department with departmentId: " + departmentId + " deleted Successfully!!";

    }

}
