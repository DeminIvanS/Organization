package org.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "employee")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityEmployee {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


}
