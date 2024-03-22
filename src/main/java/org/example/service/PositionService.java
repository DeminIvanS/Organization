package org.example.service;

import org.example.model.entity.EntityDepartmentPosition;

import java.util.List;

public interface PositionService {
    List<EntityDepartmentPosition> findAllPosition();

    EntityDepartmentPosition savePosition(EntityDepartmentPosition position, boolean isSaved);

}
