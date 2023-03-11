package dev.captainsj.springdatajpademo.model;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentIdCard")
@Table(name = "student_id_card", uniqueConstraints = {@UniqueConstraint(name = "unique_card_number", columnNames = "card_number")})
public class StudentIdCard {

    @Id
    @SequenceGenerator(name = "student_id_card_sequence", sequenceName = "student_id_card_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "student_id_card_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "card_number", columnDefinition = "TEXT", length = 15, nullable = false)
    private String cardNumber;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public StudentIdCard() {
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
