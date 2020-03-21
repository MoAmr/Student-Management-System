package com.student.dal;

import com.student.dal.entities.Student;
import com.student.dal.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {

        Student student = new Student();
        student.setName("Ali");
        student.setCourse("Java Web Services");
        student.setFees(30d);

        studentRepository.save(student);
    }

    @Test
    public void testFindStudentById() {
        Optional<Student> student = studentRepository.findById(5l);
        System.out.println(student);
    }

    @Test
    public void testUpdateStudent() {
        Optional<Student> student = studentRepository.findById(5l);
        student.ifPresent(s -> {
            s.setFees(40d);
            studentRepository.save(s);
        });
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student();
        student.setId(5l);
        studentRepository.delete(student);
    }

}
