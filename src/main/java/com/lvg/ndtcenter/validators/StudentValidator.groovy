package com.lvg.ndtcenter.validators

import com.lvg.ndtcenter.models.Student
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator


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

    }
}
