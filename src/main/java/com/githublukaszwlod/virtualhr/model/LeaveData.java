package com.githublukaszwlod.virtualhr.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LeaveData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "leave_days")
    private int leaveDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "leave_type")
    private LeaveType leaveType;
}
