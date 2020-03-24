package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class DentistVisitService {

    private final DentistVisitRepository dentistVisitRepository;

    public DentistVisitService(DentistVisitRepository dentistVisitRepository) {
        this.dentistVisitRepository = dentistVisitRepository;
    }

    public void create(DentistVisitEntity dentistVisitEntity) {
        dentistVisitRepository.save(dentistVisitEntity);
    }

    public void delete(long id) {
        dentistVisitRepository.delete(id);
    }

    public DentistVisitEntity get(long id) {
        return dentistVisitRepository.get(id);
    }

    public List<DentistVisitEntity> getAll() {
        return dentistVisitRepository.getAll();
    }

    public List<DentistVisitEntity> search(String keyword) {
        return dentistVisitRepository.search(keyword);
    }

    public List<DentistVisitEntity> findByDateBetween(LocalDateTime from, LocalDateTime to, String dentistName) {
        return dentistVisitRepository.findByDateBetween(from, to, dentistName);
    }
}