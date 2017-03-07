package com.lvg.ndtcenter.models

import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.index.Indexed

@Canonical
class Company {
    @Id
    BigInteger companyId
    @Indexed
    String name
    String address
    String phone
    String email
    @Version
    Integer version
}
