package com.lvg.tests.models.com.lvg.tests.validators

import com.lvg.ndtcenter.config.AppConfig
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = [AppConfig.class])
class StudentValidatorTest extends GroovyTestCase{


    @Test
    testValidation(){
        def student = RObjects.testStudent

    }
}
