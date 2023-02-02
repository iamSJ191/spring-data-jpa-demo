package dev.captainsj.springdatajpademo.repository;

import dev.captainsj.springdatajpademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}