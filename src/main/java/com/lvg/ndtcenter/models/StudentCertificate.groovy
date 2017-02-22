package com.lvg.ndtcenter.models

import com.lvg.ndtcenter.config.R
import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class StudentCertificate {
    Long id
    String number
    LocalDate assignDate
    LocalDate bestBeforeDate
    NDTMethod method
    Set<ISOSectors> sectors = []
    QualifRate qualifRate

    String getNumber(){
        return null == number ? R.DefaultValues.DEFAULT_STUDENT_CERT_NUMBER: number
    }

    LocalDate getAssignDate(){
        return null == assignDate ? R.DefaultValues.DEFAULT_STUDENT_CERT_ASSIGN_DATE : assignDate
    }

    LocalDate getBestBeforeDate(){
        return null == bestBeforeDate ? getAssignDate().plusYears(
                R.DefaultValues.DEFAULT_STUDENT_CERT_BEST_BEFORE_YEARS): bestBeforeDate
    }

    Set<ISOSectors> getSectors(){
        if (!sectors){
            sectors.addAll(R.DefaultValues.DEFAULT_SECTORS_SET)
        }
        sectors
    }

    QualifRate getQualifRate(){
        return null == qualifRate ? R.DefaultValues.DEFAULT_STUDENT_CERT_QUALIF_RATE: qualifRate
    }
}
