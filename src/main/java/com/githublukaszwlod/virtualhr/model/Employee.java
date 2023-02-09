package com.githublukaszwlod.virtualhr.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


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
        //@DateTimeFormat(pattern = "dd-MM-yyyy")
        private LocalDate dateOfBirth;
        private int phoneNumber;

    }

