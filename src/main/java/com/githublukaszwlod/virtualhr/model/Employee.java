package com.githublukaszwlod.virtualhr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String lastName;
        private String pesel;
        private String email;
        private String address;
        private int phoneNumber;

    }

