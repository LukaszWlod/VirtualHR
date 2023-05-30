package com.githublukaszwlod.virtualhr.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
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
        private String name;
        private String lastName;
        private String pesel;
        private String email;
        private String street;
        private int houseNumber;
        private String zipCode;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateOfBirth;
        private int phoneNumber;
        private String city;

        @OneToMany(mappedBy = "employee")
        private List<Salary> salaries;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private LeaveDays employeeLeaveDays;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LeaveData> leaveDataList;



    }

