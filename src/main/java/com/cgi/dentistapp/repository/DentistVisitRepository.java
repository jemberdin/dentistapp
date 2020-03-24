package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DentistVisitRepository {

    private CrudDentistVisitRepository crudRepository;

    public DentistVisitRepository(CrudDentistVisitRepository crudRepository) { this.crudRepository = crudRepository; }

    public DentistVisitEntity save(DentistVisitEntity dentistVisitEntity) { return crudRepository.save(dentistVisitEntity); }

    public boolean delete(long id) {
        return crudRepository.delete(id) != 0;
    }

    public DentistVisitEntity get(long id) { return crudRepository.findById(id).orElse(null); }

    public List<DentistVisitEntity> getAll() {
        return crudRepository.findAll();
    }

    public List<DentistVisitEntity> search(String keyword) {
        return crudRepository.search(keyword);
    }

    public List<DentistVisitEntity> findByDateBetween(LocalDateTime from, LocalDateTime to, String dentistName) {
        return crudRepository.findByDateBetween(from,to, dentistName);
    }
}
