package com.lvg.ndtcenter.services

interface CommonService<T> {
    List<T> findAll()
    T save(T record)
    void delete(T record)
    T findByID(BigInteger id)
}