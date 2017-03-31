package com.lvg.ndtcenter.models

import com.lvg.ndtcenter.config.R
import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.format.annotation.DateTimeFormat

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import java.time.LocalDate

@Canonical
class Student {
    @Id
    BigInteger studentId
    @Min(2l)
    String name
    @Min(2l)
    String secondName
    @Min(2l)
    String lastName
    @DateTimeFormat(pattern = R.DefaultValues.DEFAULT_DATE_FORMAT_PATTERN)
    LocalDate birthDate
    String birthPlace
    String homeAddress
    String phone
    String email
    @Version
    Integer version

    LocalDate getBirthDate(){
        return birthDate == null ? R.DefaultValues.DEFAULT_BIRTH_DATE : birthDate
    }

    String getBirthPlace(){
        return birthPlace == null ? R.DefaultValues.DEFAULT_BIRTH_PLACE : birthPlace
    }


    @Override
    String toString() {
        return "$lastName $name $secondName"
    }
}
