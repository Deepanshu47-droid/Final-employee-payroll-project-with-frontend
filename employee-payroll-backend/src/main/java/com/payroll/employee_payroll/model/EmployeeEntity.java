package com.payroll.employee_payroll.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.payroll.employee_payroll.dto.EmployeeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee name
    private double salary;

    @Column(nullable = false)
    // Employee salary
    private String name;
    // Employee gender
    private String gender;

    //Employee note
    private String note;

    @Column(nullable=false)
    // Employee startDate
    private LocalDate startDate;

    // Employee profilePic
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department_name")
    // Employee department
    private List<String> department;


    // Parameterized Constructor to initialize the Employee details
    public EmployeeEntity( String name, double salary, String gender, String note, LocalDate startDate, String profilePic) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.note = note;
        this.startDate = startDate;
        this.profilePic = profilePic;
    }

}