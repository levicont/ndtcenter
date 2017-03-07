package com.lvg.ndtcenter.repositories

import com.lvg.ndtcenter.models.Company
import org.springframework.data.mongodb.repository.MongoRepository

interface CompanyRepository extends MongoRepository <Company, BigInteger>{
    Company findByName(String name)
    Company findByCompanyId(BigInteger bigInteger)
}