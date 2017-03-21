package com.lvg.tests.models.com.lvg.tests.services

import com.lvg.ndtcenter.models.NDTMethod
import com.lvg.ndtcenter.services.CompanyService
import com.lvg.ndtcenter.services.DirectionService
import com.lvg.ndtcenter.services.StudentService
import com.lvg.tests.models.com.lvg.tests.mongo.GCommonMongoTest
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static com.lvg.tests.models.com.lvg.tests.config.RObjects.DataBase.DIRECTION_COLLECTION_NAME
import static com.lvg.tests.models.com.lvg.tests.config.RObjects.getTestDirection

class GDirectionServiceTest extends GCommonMongoTest{

    @Autowired
    DirectionService service
    @Autowired
    StudentService studentService
    @Autowired
    CompanyService companyService

    @Before
    void setup(){
        init(DIRECTION_COLLECTION_NAME)
    }

    @Test
    void testDirectionServiceSave(){
        def direction = testDirection
        def direction1 = service.save(direction)
        assert 1 == service.findAll().size()
        assert direction1.method == direction.method
    }

    @Test
    void testDirectionServiceDelete(){
        def direction = testDirection
        def direction1 = service.save(direction)
        assert 1 == service.findAll().size()
        service.delete(direction1)
        assert 0 == service.findAll().size()
    }

    @Test
    void testDirectionServiceFindById(){
        def direction = testDirection
        def direction1 = service.save(direction)
        assert 1 == service.findAll().size()
        assert null != service.findByID(direction1.directionId)
    }

    @Test
    void testDirectionServiceUpdate(){
        def direction = testDirection
        def direction1 = service.save(direction)
        assert direction.method == direction1.method
        assert null != direction1.student.studentId
        assert null != direction1.company.companyId

        direction1.method = NDTMethod.RT
        direction1.student.name = 'IVAN'
        direction1.company.name = 'Microsoft'

        service.save(direction1)

        assert direction1.directionId == service.findByID(direction1.directionId).directionId
        assert NDTMethod.RT == service.findByID(direction1.directionId).method

        def student = studentService.findByID(direction1.student.studentId)
        def company = companyService.findByID(direction1.company.companyId)
        assert 'IVAN' == student.name
        assert 'Microsoft' == company.name
    }
}
