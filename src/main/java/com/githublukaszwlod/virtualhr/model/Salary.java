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
    private double workedHours;
    private double pensionablePay;
    private double disabilityInsurance;
    private double sicknessInsurance;
    private double grossSalary;
    private double netSalary;
    private int vacationDays;
    private int sickLeaveDays;
    private double sickLeavePay;
    private  double tax;
    double vacationPayment;
    double overtimeHours;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;


}
