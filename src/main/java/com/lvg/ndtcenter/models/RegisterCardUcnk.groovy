package com.lvg.ndtcenter.models

import java.time.LocalDate

class RegisterCardUcnk {
    Long registerCardUcnkId
    String number
    String education
    String dimplomQualification
    String ndtEducation
    String job
    String jobPhone
    String jobExpirience
    LocalDate assignDate
    Direction direction

    LocalDate getAssignDate(){
        return null == assignDate ? LocalDate.now(): assignDate
    }
}
