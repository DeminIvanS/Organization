package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.entity.EntityDepartment;
import org.example.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping
    public List<EntityDepartment> getAllDepartments() {
        return departmentService.findAllDepartment();
    }
}
