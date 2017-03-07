package com.lvg.ndtcenter.repositories

import com.lvg.ndtcenter.models.Student
import org.springframework.data.mongodb.repository.MongoRepository

interface StudentRepository extends MongoRepository<Student, BigInteger>{
    List<Student> findByName(String name)
    List<Student> findByLastName(String lastName)
    Student findByStudentId(BigInteger studentId)
}
