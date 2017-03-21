package com.lvg.tests.models.com.lvg.tests.services

import com.lvg.ndtcenter.services.CompanyService
import com.lvg.tests.models.com.lvg.tests.mongo.GCommonMongoTest
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static com.lvg.tests.models.com.lvg.tests.config.RObjects.DataBase.COMPANY_COLLECTION_NAME
import static com.lvg.tests.models.com.lvg.tests.config.RObjects.getTestCompany

class GCompanyServiceTest extends GCommonMongoTest{
    @Autowired
    CompanyService service

    @Before
    void setup(){
        init(COMPANY_COLLECTION_NAME)
    }

    @Test
    void testCompanyServiceSave(){
        def company = testCompany
        def company1 = service.save(company)
        assert 1 == service.findAll().size()
        assert company1.name == company.name
    }

    @Test
    void testCompanyServiceDelete(){
        def company = testCompany
        def company1 = service.save(company)
        assert 1 == service.findAll().size()
        service.delete(company1)
        assert 0 == service.findAll().size()
    }

    @Test
    void testCompanyServiceFindById(){
        def company = testCompany
        def company1 = service.save(company)
        assert 1 == service.findAll().size()
        assert null != service.findByID(company1.companyId)
    }

    @Test
    void testCompanyServiceUpdate(){
        def company = testCompany
        def company1 = service.save(company)
        assert company.name == company1.name
        company1.name = 'TDD'
        service.save(company1)
        assert company1.companyId == service.findByID(company1.companyId).companyId
        assert 'TDD' == service.findByID(company1.companyId).name
    }
}
