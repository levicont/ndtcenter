package com.lvg.tests.models.com.lvg.tests.mongo

import com.lvg.ndtcenter.models.Company
import com.lvg.ndtcenter.repositories.CompanyRepository
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static com.lvg.tests.models.com.lvg.tests.config.RObjects.DataBase.*

class GCompanyRepositoryTest extends GCommonMongoTest{
    private final Company company = RObjects.getTestCompany()

    @Autowired
    CompanyRepository repository

    @Before
    void setup(){
        init(COMPANY_COLLECTION_NAME)
    }

    @Test
    void testCompanySave(){
        def company2 = repository.save(company)
        assert company2.companyId != null
        assert company2.email == RObjects.getTestCompany().email
        Company company1 = repository.findByCompanyId(company2.companyId)
        assert company2 == company1
    }

    @Test
    void testCompanyUpdate(){
        def company1 = repository.save(company)
        def newName = 'Microsoft'
        company1.name = newName
        company1 = repository.save(company1)
        Company company2 = repository.findByCompanyId(company1.companyId)
        assert company2.name == newName
    }

    @Test
    void testCompanyDelete(){
        def company1 = repository.save(company)
        assert 1 == repository.count()
        repository.delete(company1)
        assert 0 == repository.count()
    }

    @Test
    void testCompanyFindByName(){
        def company1 = repository.save(company)
        Company comp = repository.findByName(company1.name)
        assert company1 == comp
    }

}
