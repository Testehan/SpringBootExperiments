package com.testehan.SpringBootExperiments.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student dan = new Student(1L,"Dan", LocalDate.of(1900, Month.APRIL,30),"abc@gmail.com");
            Student alex = new Student("Alex", LocalDate.of(1900, Month.APRIL,30),"alex@gmail.com");

            studentRepository.saveAll(Arrays.asList(dan,alex));
        };
    };
}
