package org.example.repository;

import org.example.model.entity.EntityDepartment;
import org.example.model.entity.MyDepartmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityDepartmentRepository extends JpaRepository<EntityDepartment, MyDepartmentId> {

}