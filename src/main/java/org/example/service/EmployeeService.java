package org.example.service;

import org.example.DTO.EmployeeDTO;
import org.example.model.entity.EntityEmployee;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDTO> findAllEmployee();

    EntityEmployee save(EmployeeDTO employeeDTO);

    EmployeeDTO findByIdEmployee(Long id);

    List<EntityEmployee> findAll();
}

