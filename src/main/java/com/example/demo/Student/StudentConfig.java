package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {

        return args -> {

            Student zayn = new Student(
                    1L,
                    "zayn",
                    "zayn@gmail.com",
                    LocalDate.of(2006, Month.OCTOBER, 06)

            );
            Student nasir = new Student(
                    1L,
                    "nasir",
                    "nasir@gmail.com",
                    LocalDate.of(2003, Month.JUNE, 28)

            );
            Student wilda = new Student(
                    1L,
                    "wilda",
                    "wilda@gmail.com",
                    LocalDate.of(2003, Month.JUNE, 28)

            );
            repository.saveAll(
                    List.of(zayn, nasir, wilda));
        };

    }
}