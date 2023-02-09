package com.githublukaszwlod.virtualhr;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.EmployeeServiceImp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;



@SpringBootApplication
public class VirtualHrApplication {


    public static void main(String[] args) {
        SpringApplication.run(VirtualHrApplication.class, args);

    }



    @Bean
    public CommandLineRunner demo(EmployeeServiceImp employeeService) {
        return (args) -> {
            employeeService.safeEmployee(new Employee(
                    1l, "Jan", "Kowalski", "99001102031",
                    "jan@wp.pl", "Kwiatowa", 1,
                    "22-222",LocalDate.of(2020, 1, 8), 777666111
            ));
        };


    }

}
