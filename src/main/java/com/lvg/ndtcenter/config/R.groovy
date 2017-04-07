package com.lvg.ndtcenter.config

import com.lvg.ndtcenter.models.ISOSectors
import com.lvg.ndtcenter.models.QualifRate

import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

interface R {
    interface Templates{
        String DIRECTION_LIST_TEMPLATE = 'directions-table'
        String DIRECTION_TEMPLATE = 'direction'
    }
    interface DefaultValues{
        int DEFAULT_BIRTH_YEAR = 1990
        Month DEFAULT_BIRTH_MONTH = Month.JANUARY
        int DEFAULT_BIRTH_DAY = 1
        String DEFAULT_DATE_FORMAT_PATTERN = 'dd.MM.yyyy'
        DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT_PATTERN)
        LocalDate DEFAULT_BIRTH_DATE = LocalDate.of(DEFAULT_BIRTH_YEAR,DEFAULT_BIRTH_MONTH,DEFAULT_BIRTH_DAY)
        String DEFAULT_BIRTH_PLACE = ''
        String DEFAULT_STUDENT_CERT_NUMBER = "${LocalDate.now().year}-000"[2..-1]
        LocalDate DEFAULT_TEACHER_CERT_ASSIGN_DATE = LocalDate.now()
        LocalDate DEFAULT_STUDENT_CERT_ASSIGN_DATE = LocalDate.now()
        Integer DEFAULT_STUDENT_CERT_BEST_BEFORE_YEARS = 3
        QualifRate DEFAULT_STUDENT_CERT_QUALIF_RATE = QualifRate.II
        QualifRate DEFAULT_DIRECTION_QUALIF_RATE = QualifRate.II
        List<ISOSectors> DEFAULT_SECTORS_SET = [ISOSectors.ONE, ISOSectors.TWO, ISOSectors.THREE, ISOSectors.FOUR,
                                                ISOSectors.FIVE]
    }

}