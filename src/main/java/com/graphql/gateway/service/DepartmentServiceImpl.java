package com.graphql.gateway.service;

import com.graphql.gateway.entity.Department;
import com.graphql.gateway.outputDTO.DepartmentOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    @Override
    public DepartmentOutput addNewDepartment(Department department) {
        return DepartmentOutput.builder().build();
    }

    @Override
    public List<DepartmentOutput> getAllDepartment() {
        return List.of();
    }

    @Override
    public DepartmentOutput getDepartmentById(Long departmentId) {
        return null;
    }

    @Override
    public DepartmentOutput updateDepartmentById(Long departmentId, Department department) {
        return null;
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        return "";
    }

}
