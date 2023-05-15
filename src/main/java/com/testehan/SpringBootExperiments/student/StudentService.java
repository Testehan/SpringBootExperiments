package com.testehan.SpringBootExperiments.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
        Optional<Student> result = studentRepository.findStudentByEmail(student.getEmail());
        if (result.isPresent()){
            throw new IllegalStateException("email taken");
        } else {
            studentRepository.save(student);
        }

    }

    public void deleteStudent(Long studentId) {
        boolean isStudentInDB = studentRepository.existsById(studentId);
        if (!isStudentInDB){
            throw new IllegalStateException("Student with id " + studentId + " does not exist in the DB");
        } else {
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            if (name!=null && name.length()>0 && !Objects.equals(name,student.getName())) {
                student.setName(name);
            }
            if (email!=null && email.length()>0 && !Objects.equals(email,student.getEmail())) {
                student.setEmail(email);
            }
        } else {
            throw new IllegalStateException("Student with id " + studentId + " does not exist in the DB");
        }

    }
}
