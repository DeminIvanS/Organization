package org.example.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.DTO.EmployeeDTO;
import org.example.model.entity.EntityDepartment;
import org.example.model.entity.EntityDepartmentPosition;
import org.example.model.entity.EntityEmployee;
import org.example.model.entity.MyDepartmentId;
import org.example.model.enums.Department;
import org.example.repository.EntityDepartmentRepository;
import org.example.repository.EntityEmployeeRepository;
import org.example.repository.EntityPositionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ServiceImpl implements EmployeeService, DepartmentService, PositionService {

    private final EntityEmployeeRepository employeeRepository;
    private final EntityDepartmentRepository departmentRepository;
    private final EntityPositionRepository positionRepository;


    @Override
    public List<EmployeeDTO> findAllEmployee() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<EntityEmployee> employeeList = employeeRepository.findAll();
        for (int i = 0; i < employeeList.size(); i++) {

            Long employeeId = employeeList.get(i).getId();

            employeeDTOS.add(findByIdEmployee(employeeId));
        }

        return employeeDTOS;
    }


    @Override
    public EmployeeDTO findByIdEmployee(Long id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        EntityEmployee employee = employeeRepository.findById(id).orElse(null);
        EntityDepartmentPosition departmentPosition = positionRepository.findById(id).orElse(null);
        MyDepartmentId departmentId = getDepartmentId(employee);
        EntityDepartment department = departmentRepository.findById(departmentId).orElse(null);

        fillEntity(employee, departmentPosition, department, employeeDTO);

        return employeeDTO;
    }

    @Override
    public List<EntityEmployee> findAll() {
        return null;
    }

    @Override
    public List<EntityDepartment> findAllDepartment() {
        return departmentRepository.findAll();
    }

    private MyDepartmentId getDepartmentId(EntityEmployee employee) {
        MyDepartmentId departmentId = new MyDepartmentId();
        departmentId.setLastName(employee.getLastName());
        for (Department d : Department.values()) {
            departmentId.setDepartment(d);
            if ((departmentRepository.findById(departmentId).orElse(null)) == null) {

            } else {
                return departmentId;
            }
        }
        return departmentId;
    }


    private EmployeeDTO fillEntity(EntityEmployee employee, EntityDepartmentPosition position, EntityDepartment department, EmployeeDTO employeeDTO) {

        employeeDTO.setId(employee.getId());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setPosition(position.getPosition());
        employeeDTO.setDepartment(department.getDepartment());
        return employeeDTO;
    }

    @Override
    public List<EntityDepartmentPosition> findAllPosition() {
        return positionRepository.findAll();
    }


    @Transactional
    @Override
    public EntityEmployee save(EmployeeDTO employeeDTO) {
        EntityEmployee employee = new EntityEmployee();
        EntityDepartmentPosition departmentPosition = new EntityDepartmentPosition();
        EntityDepartment department = new EntityDepartment();
        MyDepartmentId departmentId = new MyDepartmentId();

        initializeEmployee(employeeDTO, employee);
        initializeDepartment(employeeDTO, department);
        initializeDepartmentId(employeeDTO, departmentId);
        departmentPosition.setPosition(employeeDTO.getPosition());
        boolean isSaved = isSavedDepartment(departmentId);
        saveDepartment(department);
        savePosition(departmentPosition, isSaved);


        return employeeRepository.saveCustom(employee, isSaved);

    }

    @Override
    public EntityDepartment saveDepartment(EntityDepartment department) {

        return departmentRepository.save(department);
    }

    private boolean isSavedDepartment(MyDepartmentId id) {
        return departmentRepository.findById(id).orElse(null) == null;
    }

    private static void initializeDepartmentId(EmployeeDTO employeeDTO, MyDepartmentId departmentId) {
        departmentId.setDepartment(employeeDTO.getDepartment());
        departmentId.setLastName(employeeDTO.getLastName());
    }

    private static void initializeDepartment(EmployeeDTO employeeDTO, EntityDepartment department) {
        department.setDepartment(employeeDTO.getDepartment());
        department.setPosition(employeeDTO.getPosition());
        department.setLastName(employeeDTO.getLastName());
    }

    private static void initializeEmployee(EmployeeDTO employeeDTO, EntityEmployee employee) {
        employee.setId(employeeDTO.getId());
        employee.setLastName(employeeDTO.getLastName());
        employee.setFirstName(employeeDTO.getFirstName());
    }

    @Override
    public EntityDepartmentPosition savePosition(EntityDepartmentPosition position, boolean isSaved) {

        if (isSaved) {
            positionRepository.save(position);
        }
        return position;
    }

}






