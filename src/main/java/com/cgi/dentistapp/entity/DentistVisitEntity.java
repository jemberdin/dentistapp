package com.cgi.dentistapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "dentist_name", nullable = false)
    private String dentistName;

    @NotNull
    @Column(name = "date_time", nullable = false)
    // https://stackoverflow.com/questions/51560173/spring-boot-with-thymeleaf-handling-datetime-field/51634086
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime visitDateTime;

    public DentistVisitEntity() { }

    public DentistVisitEntity(String dentistName, LocalDateTime visitDateTime) {
        this.dentistName = dentistName;
        this.visitDateTime = visitDateTime;
    }

    public DentistVisitEntity(Long id, String dentistName, LocalDateTime visitDateTime) {
        this.id = id;
        this.dentistName = dentistName;
        this.visitDateTime = visitDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getDentistName() {
        return dentistName;
    }

    public LocalDateTime getVisitDateTime() {
        return visitDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public void setVisitDateTime(LocalDateTime visitDateTime) {
        this.visitDateTime = visitDateTime;
    }

    @Override
    public String toString() {
        return "DentistVisitEntity{" +
                "id=" + id +
                ", dentistName='" + dentistName + '\'' +
                ", visitDateTime=" + visitDateTime +
                '}';
    }
}
