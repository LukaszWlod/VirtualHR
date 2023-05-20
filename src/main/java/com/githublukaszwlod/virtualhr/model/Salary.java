package com.githublukaszwlod.virtualhr.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    private String payrollPeriod;
    private Double workedHours;
    private Double pensionablePay;
    private Double disabilityInsurance;
    private Double sicknessInsurance;
    private Double grossSalary;
    private Double netSalary;
    private int vacationDays;
    private int sickLeaveDays;
    private Double sickLeavePay;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;


}
