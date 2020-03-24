package com.cgi.dentistapp.util;

import com.cgi.dentistapp.entity.DentistVisitEntity;

import java.util.List;
import java.util.Objects;

public class DateTimeUtil {

    // Visits are prefiltered with db query for more quick search - same dentist name and three days only
    // One visit per hour is allowed for one dentist
    public static Boolean validateNew(DentistVisitEntity newEntity, List<DentistVisitEntity> filteredVisits) {
        for(DentistVisitEntity existingEntity: filteredVisits) {
            if(!Objects.equals(newEntity.getId(), existingEntity.getId())) {
                if(newEntity.getVisitDateTime().equals(existingEntity.getVisitDateTime())) return true;
                else if(!newEntity.getVisitDateTime().isBefore(existingEntity.getVisitDateTime().minusMinutes(59)) && newEntity.getVisitDateTime().isBefore(existingEntity.getVisitDateTime())) return true;
                else if(!newEntity.getVisitDateTime().isAfter(existingEntity.getVisitDateTime().plusMinutes(59)) && newEntity.getVisitDateTime().isAfter(existingEntity.getVisitDateTime())) return true;
            }
        }
        return false;
    }
}
