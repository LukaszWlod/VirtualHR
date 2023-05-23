package com.githublukaszwlod.virtualhr;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.model.Salary;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.EmployeeServiceImp;
import com.githublukaszwlod.virtualhr.service.SalaryServiceImp;
import lombok.NoArgsConstructor;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class VirtualHrApplication {





    public static void main(String[] args) {
        SpringApplication.run(VirtualHrApplication.class, args);

    }



    @Bean
    public CommandLineRunner demo(EmployeeServiceImp employeeService, SalaryServiceImp salaryService) {
        return (args) -> {
            employeeService.safeEmployee(new Employee(
                    1l, "Jan", "Kowalski", "99001102031",
                    "jan@wp.pl", "Kwiatowa", 1,
                    "22-222",LocalDate.of(2020, 1, 8), 777666111,
                    "Lublin",new ArrayList<Salary>()
            ));

            salaryService.safeSalary(new Salary(1l,employeeService.getOne(1l), "2023-01", 160.0, 300.0, 200.0, 100.0, 5000.0,
                    4000.0, 2, 2, 200.0,300,800 ,8,LocalDate.of(2022, 2, 10)));

            salaryService.safeSalary(new Salary(2l,employeeService.getOne(1l), "2023-02", 160.0, 300.0, 200.0, 100.0, 6300.0,
                    4500.0, 2, 2, 200.0,300,800 ,8,LocalDate.of(2022, 2, 10)));

            salaryService.safeSalary(new Salary(3l,employeeService.getOne(1l), "2023-03", 160.0, 300.0, 200.0, 100.0, 6000.0,
                    4200.0, 2, 2, 200.0,300,800 ,8,LocalDate.of(2022, 2, 10)));
        };


    }

}
