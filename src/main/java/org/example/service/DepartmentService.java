package org.example.service;

import org.example.model.entity.EntityDepartment;

import java.util.List;

public interface DepartmentService {
    List<EntityDepartment> findAllDepartment();

    EntityDepartment saveDepartment(EntityDepartment department);

}
