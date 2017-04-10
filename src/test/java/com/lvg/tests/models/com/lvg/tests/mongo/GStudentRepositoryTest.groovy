package com.lvg.tests.models.com.lvg.tests.mongo

import com.lvg.ndtcenter.config.R
import com.lvg.ndtcenter.models.Direction
import com.lvg.ndtcenter.models.Student
import com.lvg.ndtcenter.repositories.DirectionRepository
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
    StudentRepository studentRepository
    @Autowired
    DirectionRepository directionRepository

    @Before
    void setup(){
        init(RObjects.DataBase.STUDENT_COLLECTION_NAME)
    }

    //TODO save Direction -> save Student -> save Direction
    @Test
    void testStudentSave(){
        def direction = RObjects.testDirection

        def student2 = studentRepository.save(student)
        direction.student = student2
        direction = directionRepository.save(direction)

        LocalDate defBirthDate = LocalDate.of(R.DefaultValues.DEFAULT_BIRTH_YEAR, R.DefaultValues.DEFAULT_BIRTH_MONTH,
        R.DefaultValues.DEFAULT_BIRTH_DAY)
        assert student2.studentId != null
        assert student2.email == RObjects.getTestStudent().email
        assert defBirthDate == student2.birthDate
        Student student1 = studentRepository.findByStudentId(student2.studentId)
        assert student2 == student1

        List<Direction> directions = directionRepository.findByStudent(student1)
        if (directions){
            directions.each {assert it.student.version == student1.version}
        }
    }

    @Test
    void testStudentUpdate(){
        def student1 = studentRepository.save(student)
        def newDate = LocalDate.of(1984, Month.AUGUST, 24)
        student1.birthDate = newDate
        student1 = studentRepository.save(student1)
        Student student2 = studentRepository.findByStudentId(student1.studentId)
        assert student2.birthDate == newDate

        List<Direction> directions = directionRepository.findByStudent(student1)
        if (directions){
            directions.each {assert it.student.version == student1.version}
        }
    }

    @Test
    void testStudentDelete(){
        def student1 = studentRepository.save(student)
        assert 1 == studentRepository.count()
        studentRepository.delete(student1)
        assert 0 == studentRepository.count()
    }

    @Test
    void testStudentFindByName(){
        def student1 = studentRepository.save(student)
        List<Student> list = studentRepository.findByName(student.name)
        assert 1 == list.size()
        assert student1 == list.get(0)
    }

    @Test
    void testStudentFindByLastName(){
        def student1 = studentRepository.save(student)
        List<Student> list = studentRepository.findByLastName(student.lastName)
        assert 1 == list.size()
        assert student1 == list.get(0)
    }
}
