package com.githublukaszwlod.virtualhr.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RequestLeaveData {
    private String dateIn;
    private String dateOut;
    private int leaveDays;
    private String recipient;
}
