package com.lvg.tests.models.com.lvg.tests.validators

import com.lvg.ndtcenter.config.AppConfig
import com.lvg.ndtcenter.validators.StudentValidator
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.MessageSource
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.ObjectError
import org.springframework.validation.ValidationUtils

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = [AppConfig.class])
class StudentValidatorTest extends GroovyTestCase{

    @Autowired
    StudentValidator studentValidator
    @Autowired
    MessageSource messages

    @Test
    void testValidation(){
        def student = RObjects.testStudent
        assert studentValidator != null
        student.name = ''
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(student, 'Student')
        ValidationUtils.invokeValidator(studentValidator, student, result)
        List<ObjectError> errors = result.allErrors
        def printErrors = { error ->
            error.each {println messages.getMessage(it.code+'', null, null)}}
        printErrors(errors)
        assert errors.size() == 2


        def student2 = RObjects.testStudent
        result = new BeanPropertyBindingResult(student, 'student')

        student.name = 'W'
        student.lastName = 'X'
        student.secondName = 'Y'
        ValidationUtils.invokeValidator(studentValidator, student, result)
        errors = result.allErrors
        printErrors(errors)
        assert errors.size() == 3
    }
}
