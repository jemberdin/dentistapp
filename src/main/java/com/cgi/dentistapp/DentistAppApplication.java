package com.cgi.dentistapp;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class DentistAppApplication {

    private final DentistVisitRepository dentistVisitRepository;

    public DentistAppApplication(DentistVisitRepository dentistVisitRepository) {
        this.dentistVisitRepository = dentistVisitRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DentistAppApplication.class, args);
    }

    @PostConstruct
    public void addDemoVisits() {
        dentistVisitRepository.save(new DentistVisitEntity("Tiina Laurits", LocalDateTime.now().plusHours(1)));
        dentistVisitRepository.save(new DentistVisitEntity("Helena Laar", LocalDateTime.now().plusHours(2)));
        dentistVisitRepository.save(new DentistVisitEntity("Madis Laht", LocalDateTime.now().plusHours(3)));
        dentistVisitRepository.save(new DentistVisitEntity("Tiiu Parn", LocalDateTime.now().plusHours(4)));
        dentistVisitRepository.save(new DentistVisitEntity("Rudolf Mark", LocalDateTime.now().plusHours(5)));
        dentistVisitRepository.save(new DentistVisitEntity("Ain Kallas", LocalDateTime.now().plusHours(6)));
    }
}
