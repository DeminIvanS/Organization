package org.example.repository;

import org.example.model.entity.EntityDepartmentPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityPositionRepository extends JpaRepository<EntityDepartmentPosition, Long> {

}