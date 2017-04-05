package com.lvg.ndtcenter.validators

import com.lvg.ndtcenter.models.Student
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

@Component
class StudentValidator implements Validator{
    @Override
    boolean supports(Class<?> aClass) {
        return Student.class == aClass
    }

    @Override
    void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,'name', 'invalid.student.name')
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,'lastName', 'invalid.student.lastName')
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,'secondName', 'invalid.student.secondName')

        Student student = o
        def size = 2..30
        def nameSize = student.name.size()
        if (!size.contains(nameSize)){
            errors.rejectValue('name','invalid.student.name.size','invalid.student.name.size')
        }
        if (!size.contains(student.lastName.size())){
            errors.rejectValue('lastName','invalid.student.lastName.size','invalid.student.lastName.size')
        }
        if (!size.contains(student.secondName.size())){
            errors.rejectValue('secondName','invalid.student.secondName.size','invalid.student.secondName.size')
        }

    }
}
