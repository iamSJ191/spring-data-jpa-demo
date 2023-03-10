package dev.captainsj.springdatajpademo.repository;

import dev.captainsj.springdatajpademo.model.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {
}
