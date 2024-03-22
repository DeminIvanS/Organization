package org.example.repository;

import org.example.model.entity.EntityEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityEmployeeRepository extends JpaRepository<EntityEmployee, Long> {
    default EntityEmployee saveCustom(EntityEmployee employee, boolean isSaved) {
        if (isSaved) {
            save(employee);
        }
        return employee;
    }

}