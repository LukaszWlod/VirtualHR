package com.githublukaszwlod.virtualhr.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LeaveDays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private int annualLeaveDays;
    private int requestedLeaveDays;
    private int occasionalLeaveDays;
    private int parentalLeaveDays;

}
