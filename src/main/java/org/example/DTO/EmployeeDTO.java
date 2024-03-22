package org.example.DTO;

import lombok.Getter;
import lombok.Setter;
import org.example.model.entity.EntityEmployee;
import org.example.model.enums.Department;
import org.example.model.enums.DepartmentPosition;

@Getter
@Setter
public class EmployeeDTO extends EntityEmployee {
    private long id;
    private String firstName;
    private String lastName;
    private DepartmentPosition position;
    private Department department;

}
