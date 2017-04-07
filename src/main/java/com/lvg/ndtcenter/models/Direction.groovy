package com.lvg.ndtcenter.models

import com.lvg.ndtcenter.config.R
import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.format.annotation.DateTimeFormat

import java.time.LocalDate

import static com.lvg.ndtcenter.config.R.DefaultValues.DEFAULT_DATE_FORMAT_PATTERN

@Canonical
class Direction {
    @Id
    BigInteger directionId
    String requestNumber
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = DEFAULT_DATE_FORMAT_PATTERN)
    LocalDate requestDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = DEFAULT_DATE_FORMAT_PATTERN)
    LocalDate bestBeforeDate
    NDTMethod method
    QualifRate qualifRate
    Set<ISOSectors> sectors = []
    Integer learnHours
    Student student
    Company company
    @Version
    Integer version


    LocalDate getBestBeforeDate(){
        bestBeforeDate = getRequestDate().plusYears(1)
        return bestBeforeDate
    }

    LocalDate getRequestDate(){
        return requestDate == null ? LocalDate.now() : requestDate
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
