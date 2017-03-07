package com.lvg.ndtcenter.listeners

import com.lvg.ndtcenter.models.Direction
import com.lvg.ndtcenter.repositories.CompanyRepository
import com.lvg.ndtcenter.repositories.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent
import org.springframework.stereotype.Component

@Component
class DirectionDbListener extends AbstractMongoEventListener<Direction>{

    @Autowired
    StudentRepository studentRepository
    @Autowired
    CompanyRepository companyRepository

    @Override
    void onBeforeConvert(BeforeConvertEvent<Direction> event) {
        def direction = event.getSource()
        def student = direction.student
        def company = direction.company

        student = studentRepository.save(student)
        company = companyRepository.save(company)

        direction.student = student
        direction.company = company
    }
}
