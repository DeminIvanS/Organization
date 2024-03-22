package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.model.entity.EntityDepartmentPosition;
import org.example.service.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public List<EntityDepartmentPosition> getAllPositions() {
        return positionService.findAllPosition();
    }
}
