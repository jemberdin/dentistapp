package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudDentistVisitRepository extends JpaRepository<DentistVisitEntity, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM DentistVisitEntity d WHERE d.id=:id")
    int delete(@Param("id") long id);

    @Query("SELECT d FROM DentistVisitEntity d ORDER BY d.visitDateTime ASC")
    List<DentistVisitEntity> findAll();

    @Query("SELECT d FROM DentistVisitEntity d WHERE d.dentistName=:dentist AND d.visitDateTime >= :from and d.visitDateTime <= :to")
    List<DentistVisitEntity> findByDateBetween(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to, @Param("dentist") String dentistName);

    @Query("SELECT d FROM DentistVisitEntity d WHERE d.dentistName LIKE %?1%")
    List<DentistVisitEntity> search(@Param("keyword") String keyword);
}
