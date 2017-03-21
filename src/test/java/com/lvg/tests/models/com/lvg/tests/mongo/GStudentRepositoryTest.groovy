package com.lvg.tests.models.com.lvg.tests.mongo

import com.lvg.ndtcenter.config.R
import com.lvg.ndtcenter.models.Student
import com.lvg.ndtcenter.repositories.StudentRepository
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDate
import java.time.Month


class GStudentRepositoryTest extends GCommonMongoTest{
    private final Student student = RObjects.getTestStudent()

    @Autowired
    StudentRepository repository

    @Before
    void setup(){
        init(RObjects.DataBase.STUDENT_COLLECTION_NAME)
    }

    @Test
    void testStudentSave(){
        def student2 = repository.save(student)
        LocalDate defBirthDate = LocalDate.of(R.DefaultValues.DEFAULT_BIRTH_YEAR, R.DefaultValues.DEFAULT_BIRTH_MONTH,
        R.DefaultValues.DEFAULT_BIRTH_DAY)
        assert student2.studentId != null
        assert student2.email == RObjects.getTestStudent().email
        assert defBirthDate == student2.birthDate
        Student student1 = repository.findByStudentId(student2.studentId)
        assert student2 == student1
    }

    @Test
    void testStudentUpdate(){
        def student1 = repository.save(student)
        def newDate = LocalDate.of(1984, Month.AUGUST, 24)
        student1.birthDate = newDate
        student1 = repository.save(student1)
        Student student2 = repository.findByStudentId(student1.studentId)
        assert student2.birthDate == newDate
    }

    @Test
    void testStudentDelete(){
        def student1 = repository.save(student)
        assert 1 == repository.count()
        repository.delete(student1)
        assert 0 == repository.count()
    }

    @Test
    void testStudentFindByName(){
        def student1 = repository.save(student)
        List<Student> list = repository.findByName(student.name)
        assert 1 == list.size()
        assert student1 == list.get(0)
    }

    @Test
    void testStudentFindByLastName(){
        def student1 = repository.save(student)
        List<Student> list = repository.findByLastName(student.lastName)
        assert 1 == list.size()
        assert student1 == list.get(0)
    }
}
