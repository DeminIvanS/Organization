package org.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.example.model.enums.Department;
import org.example.model.enums.DepartmentPosition;

import java.io.Serializable;

@Table(name = "department")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@IdClass(MyDepartmentId.class)
public class EntityDepartment implements Serializable {


    @Id
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "department_id")
    private Department department;
    @Id
    private String lastName;

    @Enumerated(EnumType.STRING)
    private DepartmentPosition position;


}
