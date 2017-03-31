package com.lvg.tests.models.com.lvg.tests.mongo

import com.lvg.ndtcenter.models.Direction
import com.lvg.ndtcenter.models.NDTMethod
import com.lvg.ndtcenter.repositories.DirectionRepository
import com.lvg.ndtcenter.repositories.StudentRepository
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static com.lvg.tests.models.com.lvg.tests.config.RObjects.DataBase.*


class GDirectionRepositoryTest extends GCommonMongoTest{
    private Direction direction = RObjects.getTestDirection()

    @Autowired
    DirectionRepository directionRepository
    @Autowired
    StudentRepository studentRepository



    @Before
    void setup(){
        init(DIRECTION_COLLECTION_NAME)
    }

    @Test
    void testDirectionSave(){
        def direction1 = directionRepository.save(direction)
        assert null != direction1.directionId
        assert null != direction1.requestNumber
        assert null != direction1.student.studentId
        assert null != direction1.company.companyId

    }

    @Test
    void testDirectionUpdate(){
        def direction1 = directionRepository.save(direction)
        direction1.method = NDTMethod.RT
        direction1.student.name = 'IVAN'
        direction1.company.name = 'Microsoft'
        def direction2 = directionRepository.save(direction1)
        def student = studentRepository.findByStudentId(direction2.student.studentId)
        assert null != student
        assert 'IVAN' == student.name
        assert NDTMethod.RT == direction2.method
        assert 'IVAN' == direction2.student.name
        assert 'Microsoft' == direction2.company.name

        direction1 = directionRepository.findByDirectionId(direction.directionId)
        def studentId = direction.student.studentId
        direction1.student = null

        student = studentRepository.findByStudentId(studentId)

        direction1.student = student
        direction1.student.name = 'RICHARD'
        direction2 = directionRepository.save(direction1)

        student = studentRepository.findByStudentId(student.studentId)

        assert  null != direction2
        assert  direction2.student.name == 'RICHARD'
        assert direction2.student.version == student.version
    }

    @Test
    void testDirectionDelete(){
        def direction1 = directionRepository.save(direction)
        assert 1 == directionRepository.count()
        def student = direction.student
        directionRepository.delete(direction1)
        assert 0 == directionRepository.count()
        assert student == studentRepository.findByStudentId(student.studentId)
    }

    @Test
    void testDirectionFindByStudent(){
        def direction1 = directionRepository.save(direction)
        def student = direction.student
        List<Direction> list = directionRepository.findByStudent(student)
        assert 1 == list.size()
        assert student == list.get(0).student
    }

}
