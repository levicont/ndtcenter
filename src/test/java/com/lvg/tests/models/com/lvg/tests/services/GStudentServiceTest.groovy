package com.lvg.tests.models.com.lvg.tests.services

import com.lvg.ndtcenter.models.Student
import com.lvg.ndtcenter.services.StudentService
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import com.lvg.tests.models.com.lvg.tests.mongo.GCommonMongoTest
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static com.lvg.tests.models.com.lvg.tests.config.RObjects.DataBase.STUDENT_COLLECTION_NAME


class GStudentServiceTest extends GCommonMongoTest{

    @Autowired
    StudentService service

    @Before
    void setup(){
       init(STUDENT_COLLECTION_NAME)
   }

    @Test
    void testStudentServiceSave(){
        Student student = RObjects.testStudent
        def student2 = service.save(student)
        assert 1 == service.findAll().size()
        assert student2.name == student.name
    }

    @Test
    void testStudentServiceDelete(){
        def student = RObjects.testStudent
        def student2 = service.save(student)
        assert 1 == service.findAll().size()
        service.delete(student2)
        assert 0 == service.findAll().size()
    }

    @Test
    void testStudentServiceFindById(){
        def student = RObjects.testStudent
        def student2 = service.save(student)
        assert 1 == service.findAll().size()
        assert null != service.findByID(student2.studentId)
    }

    @Test
    void testStudentServiceUpdate(){
        def student = RObjects.testStudent
        def student2 = service.save(student)
        assert student.name == student2.name
        student2.name = 'IVAN'
        service.save(student2)
        assert student2.studentId == service.findByID(student2.studentId).studentId
        assert 'IVAN' == service.findByID(student2.studentId).name
    }
}
