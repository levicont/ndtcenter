package com.lvg.ndtcenter.config

import com.lvg.ndtcenter.models.ISOSectors
import com.lvg.ndtcenter.models.QualifRate

import java.time.LocalDate
import java.time.Month

interface R {

    interface DefaultValues{
        LocalDate DEFAULT_BIRTH_DATE = LocalDate.of(1990, Month.JANUARY, 1)
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