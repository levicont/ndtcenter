package com.lvg.ndtcenter.models

import java.time.LocalDate


class RegisterCardUcnk {
    Long id
    String number
    LocalDate assignDate
    Student student
    DirectionUcnk directionUcnk
}
