package com.githublukaszwlod.virtualhr.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        private String name;
        @NotBlank
        private String lastName;
        @Size(min =11 , max = 11)
        private String pesel;
        @Email
        private String email;
        @NotBlank
        private String street;
        @NotNull
        private int houseNumber;
        @NotBlank
        private String zipCode;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateOfBirth;
        private int phoneNumber;
        @NotBlank
        private String city;

        @OneToMany(mappedBy = "employee")
        private List<Salary> salaries;

        @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
        private LeaveDays employeeLeaveDays;

        @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<LeaveData> leaveDataList;



    }

