package com.lvg.ndtcenter.models

import com.lvg.ndtcenter.config.R
import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class DirectionUcnk {
    Long id
    String num
    LocalDate assignDate
    LocalDate bestBeforeDate
    QualifRate qualifRate
    NDTMethod method
    Set<ISOSectors> sectors = []
    Integer learnHours
    Student student
    Company company


    LocalDate getBestBeforeDate(){
        bestBeforeDate = getAssignDate().plusYears(1)
        return bestBeforeDate
    }

    LocalDate getAssignDate(){
        return assignDate == null ? LocalDate.now() : assignDate
    }

    QualifRate getQualifRate(){
        return qualifRate == null ? R.DefaultValues.DEFAULT_DIRECTION_QUALIF_RATE : qualifRate
    }

    Set<ISOSectors> getSectors(){
        if (!sectors){
            sectors.addAll(R.DefaultValues.DEFAULT_SECTORS_SET)
        }
        sectors
    }

}
