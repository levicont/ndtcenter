package models;



import com.lvg.ndtcenter.models.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedHashSet;


import static org.junit.Assert.*;
import com.lvg.ndtcenter.config.R.*;

public class ModelsTest {

    @Test
    public void testStudent(){
        Student student = new Student(1l, "Иван", "Иванович", "Иванов");
        assertEquals(1l, student.getId().longValue());
        assertEquals("Иван", student.getName());
        assertEquals("Иванович", student.getSecondName());
        assertEquals("Иванов", student.getLastName());
        assertEquals(DefaultValues.DEFAULT_BIRTH_DATE, student.getBirthDate());
        assertEquals(DefaultValues.DEFAULT_BIRTH_PLACE, student.getBirthPlace());
        assertNotNull(student.getStudentCertificates());
        assertEquals(LinkedHashSet.class, student.getStudentCertificates().getClass());

    }

    @Test
    public void testTeacher(){
        Teacher teacher = new Teacher(1l, "Иван", "Иванович", "Иванов");
        assertEquals(1l, teacher.getId().longValue());
        assertEquals("Иван", teacher.getName());
        assertEquals("Иванович", teacher.getSecondName());
        assertEquals("Иванов", teacher.getLastName());

        assertNotNull(teacher.getTeacherCertificates());
        assertEquals(LinkedHashSet.class, teacher.getTeacherCertificates().getClass());
    }

    @Test
    public void testTeacherCertificate(){
        TeacherCertificate teacherCertificate = new TeacherCertificate(1l);
        teacherCertificate.setMethod(NDTMethod.VT);

        assertEquals(1l, teacherCertificate.getId().longValue());
        assertEquals(DefaultValues.DEFAULT_TEACHER_CERT_ASSIGN_DATE, teacherCertificate.getAssignDate());
        assertEquals(NDTMethod.VT, teacherCertificate.getMethod());
        assertNotNull(teacherCertificate.getSectors());
        assertEquals(5, teacherCertificate.getSectors().size());
        assertEquals(true, teacherCertificate.getSectors().contains(ISOSectors.FIVE));
    }



    @Test
    public void testStudentCertificate(){
        StudentCertificate studentCertificate = new StudentCertificate(1l);
        studentCertificate.setMethod(NDTMethod.VT);

        assertEquals(1l, studentCertificate.getId().longValue());
        assertEquals(DefaultValues.DEFAULT_STUDENT_CERT_NUMBER, studentCertificate.getNumber());
        assertEquals(DefaultValues.DEFAULT_STUDENT_CERT_ASSIGN_DATE, studentCertificate.getAssignDate());
        assertEquals(studentCertificate.getBestBeforeDate(),
                studentCertificate.getAssignDate().plusYears(DefaultValues.DEFAULT_STUDENT_CERT_BEST_BEFORE_YEARS));
        assertEquals(NDTMethod.VT, studentCertificate.getMethod());
        assertNotNull(studentCertificate.getSectors());
        assertEquals(5, studentCertificate.getSectors().size());
        assertEquals(true, studentCertificate.getSectors().contains(ISOSectors.FIVE));
        assertEquals(DefaultValues.DEFAULT_STUDENT_CERT_QUALIF_RATE, studentCertificate.getQualifRate());


    }

    @Test
    public void testCompany(){
        Company company = new Company(1l, "IBM", "California","+1008899");
        assertEquals(1l, company.getId().longValue());
        assertEquals("IBM", company.getName());
        assertEquals("California", company.getAddress());
        assertEquals("+1008899", company.getPhone());
    }

    @Test
    public void testDirectionUcnk(){

        DirectionUcnk direction = new DirectionUcnk(0l, "5000-2");
        LocalDate assignDate = direction.getAssignDate();
        assertNotNull(assignDate);
        assertEquals(assignDate.plusYears(1), direction.getBestBeforeDate());
        assertEquals(DefaultValues.DEFAULT_DIRECTION_QUALIF_RATE, direction.getQualifRate());
        assertEquals(5,direction.getSectors().size());
        assertNotNull(direction.getSectors());

    }
}
