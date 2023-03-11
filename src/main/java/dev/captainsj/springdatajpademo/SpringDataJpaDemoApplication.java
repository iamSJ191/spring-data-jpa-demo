package dev.captainsj.springdatajpademo;

import com.github.javafaker.Faker;
import dev.captainsj.springdatajpademo.model.Student;
import dev.captainsj.springdatajpademo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);


    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository) {
        return args -> {
            Faker faker = new Faker();

            for (int i = 0; i < 20; i++) {
                Student student = new Student(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.name().firstName() + faker.name().lastName() + "@sj.com",
                        faker.random().nextInt(5, 25)
                );


                studentRepository.save(student);
            }

            studentRepository.findAll().forEach(System.out::println);
        };
    }
}
