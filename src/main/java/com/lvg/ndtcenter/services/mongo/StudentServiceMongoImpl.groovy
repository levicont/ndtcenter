package com.lvg.ndtcenter.services.mongo

import com.lvg.ndtcenter.models.Student
import com.lvg.ndtcenter.repositories.StudentRepository
import com.lvg.ndtcenter.services.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service('studentService')
class StudentServiceMongoImpl implements StudentService{

    @Autowired
    StudentRepository repository

    @Override
    List<Student> findAll() {
        return repository.findAll()
    }

    @Override
    Student save(Student record) {
        return repository.save(record)
    }

    @Override
    void delete(Student record) {
        repository.delete(record)
    }

    @Override
    Student findByID(BigInteger id) {
        return repository.findByStudentId(id)
    }
}
