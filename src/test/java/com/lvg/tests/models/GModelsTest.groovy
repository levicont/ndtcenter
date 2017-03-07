package com.lvg.tests.models

import com.lvg.ndtcenter.config.R
import com.lvg.ndtcenter.models.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

@RunWith(JUnit4.class)
class GModelsTest extends GroovyTestCase{
    private static final STUDENT_TEST_KEY = "student"
    private static final TEACHER_TEST_KEY = "teacher"
    private static final TEACHER_CERT_TEST_KEY = "teacherCertificate"
    private static final COMPANY_TEST_KEY = "company"
    private static final DIRECTION_TEST_KEY = "direction"
    private static final REGISTER_CARD_UCNK_TEST_KEY = "registerCardUcnk"

    private static final testMap = [:]

    @Before
    void init(){
        Student student = new Student(1l, "Иван", "Иванович", "Иванов")
        testMap.put(STUDENT_TEST_KEY, student)

        Teacher teacher = new Teacher(1l, "Иван", "Иванович", "Иванов")
        testMap.put(TEACHER_TEST_KEY, teacher)

        TeacherCertificate teacherCertificate = new TeacherCertificate(1l)
        teacherCertificate.setMethod(NDTMethod.VT)
        testMap.put(TEACHER_CERT_TEST_KEY, teacherCertificate)

        Company company = new Company(companyId:1l, name:"IBM", address:"California",
                phone:"+1008899", email:"office@ibm.com")
        testMap.put(COMPANY_TEST_KEY, company)

        Direction direction = new Direction(0l, "5000-2")
        testMap.put(DIRECTION_TEST_KEY, direction)

        def regCard = new RegisterCardUcnk()
        regCard.direction = direction
        testMap.put(REGISTER_CARD_UCNK_TEST_KEY, regCard)

    }

    @Test
    void testStudent(){
        Student student = testMap.get(STUDENT_TEST_KEY)
        LocalDate defaultDate = LocalDate.of(1990, 01, 01)
       assert '01.01.1990' == R.DefaultValues.DEFAULT_DATE_FORMATTER.format(student.birthDate)
       assert defaultDate.format(DateTimeFormatter.ofPattern(R.DefaultValues.DEFAULT_DATE_FORMAT_PATTERN)) ==
              R.DefaultValues.DEFAULT_DATE_FORMATTER.format(student.birthDate)

        assertEquals(1l, student.studentId.longValue())
        assertEquals("Иван", student.name)
        assertEquals("Иванович", student.secondName)
        assertEquals("Иванов", student.lastName)
        assertEquals(R.DefaultValues.DEFAULT_BIRTH_DATE, student.birthDate)
        assertEquals(R.DefaultValues.DEFAULT_BIRTH_PLACE, student.birthPlace)
        assert null == student.email
        assert null == student.homeAddress
        assert null == student.phone

    }
    @Test
    void testTeacher(){
        Teacher teacher = testMap.get(TEACHER_TEST_KEY)
        assertEquals(1l, teacher.getId().longValue())
        assertEquals("Иван", teacher.getName())
        assertEquals("Иванович", teacher.getSecondName())
        assertEquals("Иванов", teacher.getLastName())
        assertNotNull(teacher.getTeacherCertificates())
        assertEquals(LinkedHashSet.class, teacher.getTeacherCertificates().getClass())
    }
    @Test
    void testTeacherCertificate(){
        TeacherCertificate teacherCertificate = testMap.get(TEACHER_CERT_TEST_KEY)
        assertEquals(1l, teacherCertificate.getId().longValue())
        assertEquals(R.DefaultValues.DEFAULT_TEACHER_CERT_ASSIGN_DATE, teacherCertificate.getAssignDate())
        assertEquals(NDTMethod.VT, teacherCertificate.getMethod())
        assertNotNull(teacherCertificate.getSectors())
        assertEquals(5, teacherCertificate.getSectors().size())
        assertEquals(true, teacherCertificate.getSectors().contains(ISOSectors.FIVE))
    }


    @Test
    void testStudentCertificate(){
        StudentCertificate studentCertificate = new StudentCertificate(1l)
        studentCertificate.setMethod(NDTMethod.VT)
        assertEquals(1l, studentCertificate.getId().longValue())
        assertEquals(R.DefaultValues.DEFAULT_STUDENT_CERT_NUMBER, studentCertificate.getNumber())
        assertEquals(R.DefaultValues.DEFAULT_STUDENT_CERT_ASSIGN_DATE, studentCertificate.getAssignDate())
        assertEquals(studentCertificate.bestBeforeDate.year,
                studentCertificate.assignDate.year+R.DefaultValues.DEFAULT_STUDENT_CERT_BEST_BEFORE_YEARS              )
        assertEquals(NDTMethod.VT, studentCertificate.getMethod())
        assertNotNull(studentCertificate.getSectors())
        assertEquals(5, studentCertificate.getSectors().size())
        assertEquals(true, studentCertificate.getSectors().contains(ISOSectors.FIVE))
        assertEquals(R.DefaultValues.DEFAULT_STUDENT_CERT_QUALIF_RATE, studentCertificate.getQualifRate())


    }
   @Test
   void testCompany(){
        Company company = testMap.get(COMPANY_TEST_KEY)
        assertEquals(1l, company.companyId.longValue())
        assertEquals("IBM", company.name)
        assertEquals("California", company.address)
        assertEquals("+1008899", company.phone)
       assert "office@ibm.com" == company.email
    }
    @Test
    void testDirection(){
        Direction direction = testMap.get(DIRECTION_TEST_KEY)
        LocalDate assignDate = direction.getRequestDate()
        assertNotNull(assignDate)
        assertEquals(assignDate.plusYears(1), direction.getBestBeforeDate())
        assertEquals(R.DefaultValues.DEFAULT_DIRECTION_QUALIF_RATE, direction.getQualifRate())
        assertEquals(5,direction.getSectors().size())
        assertNotNull(direction.getSectors())

    }
    @Test
    void testRegisterCardUcnk() {
        def regCard = testMap.get(REGISTER_CARD_UCNK_TEST_KEY)
        assert null != regCard.direction
        assert regCard.direction == testMap.get(DIRECTION_TEST_KEY)
        assert LocalDate.now() == regCard.assignDate
    }
}
