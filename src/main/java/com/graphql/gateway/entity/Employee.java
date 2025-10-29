package com.graphql.gateway.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Size(max = 50)
    @Column(nullable = false)
    private String firstName;

    @Size(max = 150)
    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 10, max = 10)
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private String position;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_fk_id")
    private Department department;

}
