package com.example.helloworld.controller;


import com.example.helloworld.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.helloworld.entity.Student; // Newly added import for Student entity
import java.util.List; // Newly added import for List
import java.util.Optional;




@RestController


public class Hello {

    @Autowired
    private HelloWorldService helloWorldService;


    @GetMapping("/hello")
    public String sayHello() {
        return helloWorldService.getHelloMessage();

    }

    // Newly added endpoint to get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return helloWorldService.getAllStudents();
    }

    // Endpoint to get a student by ID (Read operation)
    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return helloWorldService.getStudentById(id);
    }

    // Endpoint to add a new student (Create operation)
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return helloWorldService.addStudent(student);
    }

    // Endpoint to update an existing student by ID (Update operation)
    // Endpoint to update an existing student by ID (Update operation)
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return helloWorldService.updateStudent(id, studentDetails);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        helloWorldService.deleteStudent(id);

    }
}



