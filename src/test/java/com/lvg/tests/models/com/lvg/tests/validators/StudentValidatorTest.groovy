package com.lvg.tests.models.com.lvg.tests.validators

import com.lvg.ndtcenter.config.AppConfig
import com.lvg.ndtcenter.validators.StudentValidator
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.ObjectError
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = [AppConfig.class])
class StudentValidatorTest extends GroovyTestCase{

    @Autowired
    StudentValidator studentValidator

    @Test
    void testValidation(){
        def student = RObjects.testStudent
        assert studentValidator != null
        student.name = ''
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(student, 'Student')
        ValidationUtils.invokeValidator(studentValidator, student, result)
        List<ObjectError> errors = result.allErrors
        def printErrors = { errors.each {println it.code}}
        printErrors()
        assert errors.size() == 1

        student.name = 'W'
        def result2 = new BeanPropertyBindingResult(student, 'Student2')
        ValidationUtils.invokeValidator(studentValidator, student, result2)
        errors = result2.allErrors
        printErrors()
        assert errors.size() == 1
    }
}
