package com.lvg.ndtcenter.models

import com.lvg.ndtcenter.config.R
import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class Student {
    Long id
    String name
    String secondName
    String lastName
    LocalDate birthDate
    String birthPlace
    Set<StudentCertificate> studentCertificates = []

    LocalDate getBirthDate(){
        return birthDate == null ? R.DefaultValues.DEFAULT_BIRTH_DATE : birthDate
    }

    String getBirthPlace(){
        return birthPlace == null ? R.DefaultValues.DEFAULT_BIRTH_PLACE : birthPlace
    }

}
