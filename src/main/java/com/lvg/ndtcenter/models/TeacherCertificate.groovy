package com.lvg.ndtcenter.models

import com.lvg.ndtcenter.config.R
import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class TeacherCertificate {
    Long id
    String number
    LocalDate assignDate
    LocalDate bestBeforeDate
    NDTMethod method
    Set<ISOSectors> sectors = []
    QualifRate qualifRate

    LocalDate getAssignDate(){
        return assignDate == null ? R.DefaultValues.DEFAULT_TEACHER_CERT_ASSIGN_DATE : assignDate
    }

    Set<ISOSectors> getSectors(){
        if (!sectors){
            sectors.addAll(R.DefaultValues.DEFAULT_SECTORS_SET)
        }
        sectors
    }
}
