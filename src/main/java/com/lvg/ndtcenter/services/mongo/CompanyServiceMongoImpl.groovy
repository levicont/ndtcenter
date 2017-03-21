package com.lvg.ndtcenter.services.mongo

import com.lvg.ndtcenter.models.Company
import com.lvg.ndtcenter.repositories.CompanyRepository
import com.lvg.ndtcenter.services.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service('companyService')
class CompanyServiceMongoImpl implements CompanyService{

    @Autowired
    CompanyRepository repository

    @Override
    List<Company> findAll() {
        return repository.findAll()
    }

    @Override
    Company save(Company record) {
        return repository.save(record)
    }

    @Override
    void delete(Company record) {
        repository.delete(record)
    }

    @Override
    Company findByID(BigInteger id) {
        return repository.findOne(id)
    }
}
