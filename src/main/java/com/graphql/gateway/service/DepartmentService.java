package com.graphql.gateway.service;

import com.graphql.gateway.entity.Department;
import com.graphql.gateway.outputDTO.DepartmentOutput;

import java.util.List;

public interface DepartmentService {

    DepartmentOutput addNewDepartment(Department department);

    List<DepartmentOutput> getAllDepartment();

    DepartmentOutput getDepartmentById(Long departmentId);

    DepartmentOutput updateDepartmentById(Long departmentId, Department department);

    String deleteDepartmentById(Long departmentId);

}
