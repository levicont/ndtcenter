package com.lvg.tests.models.com.lvg.tests.config

import com.lvg.ndtcenter.config.R
import com.lvg.ndtcenter.models.Company
import com.lvg.ndtcenter.models.Direction
import com.lvg.ndtcenter.models.ISOSectors
import com.lvg.ndtcenter.models.NDTMethod
import com.lvg.ndtcenter.models.Student

import java.time.LocalDate


class RObjects {

    static Student getTestStudent(){
       Student student = new Student()
        student.name = 'Bill'
        student.secondName = 'William'
        student.lastName = 'Jackson'
        student.birthDate = R.DefaultValues.DEFAULT_BIRTH_DATE
        student.birthPlace = 'Utah, USA'
        student.homeAddress = 'Toronto, Canada'
        student.phone = '+123456789'
        student.email = 'bill@d.com'
        student

    }

    static Company getTestCompany(){
        Company company = new Company()
        company.name = 'IBM'
        company.address = 'California, USA'
        company.phone = '+123456789'
        company.email = 'ibm@d.com'
        company
    }

    static Direction getTestDirection(){
        Direction direction = new Direction()
        direction.company = getTestCompany()
        direction.student = getTestStudent()
        direction.method = NDTMethod.MT
        direction.requestDate = LocalDate.now()
        direction.qualifRate = R.DefaultValues.DEFAULT_DIRECTION_QUALIF_RATE
        direction.learnHours = 110
        direction.sectors = R.DefaultValues.DEFAULT_SECTORS_SET + ISOSectors.SEVEN
        direction

    }

}
