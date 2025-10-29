package com.graphql.gateway.repository;

import com.graphql.gateway.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Long, Department> {
}
