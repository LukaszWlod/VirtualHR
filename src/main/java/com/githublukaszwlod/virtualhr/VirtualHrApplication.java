package com.githublukaszwlod.virtualhr;

import com.githublukaszwlod.virtualhr.model.*;
import com.githublukaszwlod.virtualhr.service.*;
import org.aspectj.weaver.ast.Not;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.util.ArrayList;


@SpringBootApplication
public class VirtualHrApplication {





    public static void main(String[] args) {
        SpringApplication.run(VirtualHrApplication.class, args);

    }



    @Bean
    public CommandLineRunner demo(NoticeService noticeService, EmployeeServiceImp employeeService, SalaryServiceImp salaryService, LeaveDaysServiceImp leaveService) {
        return (args) -> {
            employeeService.saveEmployee(new Employee(
                    1l, "Jan", "Kowalski", "99001102031",
                    "jan@wp.pl", "Kwiatowa", 1,
                    "22-222",LocalDate.of(2020, 1, 8), 777666111,
                    "Lublin",new ArrayList<Salary>(),new LeaveDays(),new ArrayList<LeaveData>()
            ));

            salaryService.save(new Salary(1l,employeeService.getOne(1l), "2023-01", 160.0, 300.0, 200.0, 100.0, 5000.0,
                    4000.0, 2, 2, 200.0,300,800 ,8,LocalDate.of(2022, 2, 10)));

            salaryService.save(new Salary(2l,employeeService.getOne(1l), "2023-02", 160.0, 300.0, 200.0, 100.0, 6300.0,
                    4500.0, 2, 2, 200.0,300,800 ,8,LocalDate.of(2022, 2, 10)));

            salaryService.save(new Salary(3l,employeeService.getOne(1l), "2023-03", 160.0, 300.0, 200.0, 100.0, 6000.0,
                    4200.0, 2, 2, 200.0,300,800 ,8,LocalDate.of(2022, 2, 10)));

            leaveService.save(new LeaveDays(1l,employeeService.getOne(1l),26,4,2,2));

            String message = " Szanowni pracownicy,\n" +
                    "\n" +
                    "Informujemy Was z radością o wprowadzeniu nowej premii dla każdego nowego pracownika, który dołączy do naszego zespołu. Od teraz, każdy pracownik, który sprowadzi do firmy nowego pracownika, otrzyma premię w wysokości 1000 złotych.\n" +
                    "\n" +
                    "Cieszymy się z dynamicznego rozwoju naszej firmy i wierzymy, że Wasza aktywność i zaangażowanie w poszukiwaniu nowych talentów będą nagradzane.\n" +
                    "\n" +
                    "Zachęcamy Was do polecania naszej firmy swoim znajomym, rodzinie i osobom, które Waszym zdaniem mogą być doskonałymi kandydatami na stanowiska w naszej organizacji. Pamiętajcie, że nowi pracownicy przyczyniają się do rozwoju naszego zespołu i wzmocnienia naszej pozycji na rynku.\n" +
                    "\n" +
                    "Wszelkie szczegóły dotyczące procedur rekrutacyjnych oraz programu premiowego są dostępne w dziale kadr. Zachęcamy do kontaktu z naszym zespołem w przypadku pytań lub wątpliwości.\n" +
                    "\n" +
                    "Razem tworzymy sukces naszej firmy!\n" +
                    "\n" +
                    "Z poważaniem,\n" +
                    "Dział Kadr\n";
            String message2 =
                    "Drodzy pracownicy,\n" +
                    "\n" +
                    "Chcielibyśmy poinformować Was, że znaleziono pewien zestaw kluczy w naszym biurze. Jeśli ktoś zgubił swoje klucze lub wie, kto mógł je zgubić, prosimy o zgłoszenie się do recepcji w celu odebrania ich.\n" +
                    "\n" +
                    "Opis kluczy:\n" +
                    "- Zestaw zawiera 3 klucze na srebrnym breloczku.\n" +
                    "- Na jednym z kluczy znajduje się niebieska nakładka.\n" +
                    "\n" +
                    "Zachęcamy Was do sprawdzenia swoich kluczy i upewnienia się, czy nie jesteście ich właścicielami. \n" +
                    "\n" +
                    "W przypadku jakichkolwiek pytań lub dodatkowych informacji, prosimy o kontakt z działem kadr.\n" +
                    "\n" +
                    "Dziękujemy za Waszą współpracę.\n" +
                    "\n" +
                    "Z poważaniem,\n" +
                    "Dział Kadr\n";


            String message3 =
                    "Drodzy pracownicy,\n" +
                    "\n" +
                    "Z wielką radością zapraszamy Was na naszą coroczną imprezę integracyjną. Będzie to doskonała okazja do spotkania się, zabawy i wzmocnienia więzi między nami.\n" +
                    "\n" +
                    "Szczegóły imprezy:\n" +
                    "- Data: Sobota, 20 lipca\n" +
                    "- Godzina: 18:00\n" +
                    "- Miejsce: Sala bankietowa \"Pod Słonecznym Niebem\"\n" +
                    "\n" +
                    "Podczas imprezy będziecie mieli okazję delektować się wyśmienitą kolacją, tańczyć przy świetnej muzyce oraz wziąć udział w różnorodnych atrakcjach i konkursach. To także doskonała okazja, aby bliżej poznać kolegów i koleżanki z innych działów.\n" +
                    "\n" +
                    "Prosimy o potwierdzenie swojej obecności do piątku, 19 lipca, abyśmy mogli odpowiednio przygotować się pod względem ilości jedzenia i napojów. Potwierdzenie można przesłać do działu kadr drogą mailową lub osobiście zgłosić się do naszego biura.\n" +
                    "\n" +
                    "Jeśli macie jakiekolwiek pytania dotyczące imprezy, prosimy o kontakt z działem kadr. \n" +
                    "\n" +
                    "Czekamy z niecierpliwością na wspólne spotkanie!\n" +
                    "\n" +
                    "Z serdecznymi pozdrowieniami,\n" +
                    "Dział Kadr\n";
            noticeService.save(new Notice
                    (1l, LocalDate.of(2023, 5, 20)
                            ,"Wprowadzenie premii 1000 złotych za nowego pracownika",message));
            noticeService.save(new Notice
                    (2l, LocalDate.of(2023, 5, 29)
                            ,"Znalezione klucze - odbiór na recepcji",message2));
            noticeService.save(new Notice
                    (3l, LocalDate.of(2023, 6, 20)
                            ,"Impreza integracyjna - Zaproszenie dla wszystkich pracowników",message3));
        };







    }

}
