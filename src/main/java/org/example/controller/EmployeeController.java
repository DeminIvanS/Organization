package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.DTO.EmployeeDTO;
import org.example.model.entity.EntityEmployee;
import org.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("get_from_employee")
    public List<EntityEmployee> findAll() {

        return service.findAll();
    }

    @GetMapping("get_from_all_tables")
    public List<EmployeeDTO> findAllEmployees() {

        return service.findAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable Long id) {
        return service.findByIdEmployee(id);

    }

    @PostMapping("save_new_employee")
    public ResponseEntity<EntityEmployee> saveNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return mappingResponseEmployee(service.save(employeeDTO));
    }

    private ResponseEntity<EntityEmployee> mappingResponseEmployee(EntityEmployee employee) {
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


}
