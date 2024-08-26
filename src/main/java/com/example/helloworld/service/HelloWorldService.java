package com.example.helloworld.service;

import com.example.helloworld.entity.Student;
import com.example.helloworld.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HelloWorldService {


    @Autowired
    private HelloWorldRepository helloWorldRepository;


    // Method to delete a student by ID (Delete operation)


    public String getHelloMessage() {
        return "Hello World!";
    }

    // Get all students
    public List<Student> getAllStudents() {
        return helloWorldRepository.findAll();
    }

    // Get a student by ID
    public Optional<Student> getStudentById(Long id) {
        return helloWorldRepository.findById(id);
    }

    // Create a new student
    public Student addStudent(Student student) {
        return helloWorldRepository.save(student);
    }

    // Method to update an existing student (Update operation)
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = helloWorldRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirst_name(studentDetails.getFirst_name());
        student.setLast_name(studentDetails.getLast_name());
        student.setEmail(studentDetails.getEmail());
        student.setDate_of_birth(studentDetails.getDate_of_birth());
        student.setEnrollment_date(studentDetails.getEnrollment_date());
        return helloWorldRepository.save(student);
    }


    // Method to delete a student by ID (Delete operation)
    public void deleteStudent(Long id) {
        if (!helloWorldRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        helloWorldRepository.deleteById(id);
    }


}
