package org.example.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.example.model.enums.Department;

@Getter
@Setter
public class MyDepartmentId {
    private Department department;
    private String lastName;


}
