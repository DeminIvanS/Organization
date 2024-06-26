package org.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.example.model.enums.DepartmentPosition;

@Table(name = "position")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class EntityDepartmentPosition {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)

    private DepartmentPosition position;


}
