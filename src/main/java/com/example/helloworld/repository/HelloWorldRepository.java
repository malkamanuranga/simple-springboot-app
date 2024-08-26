package com.example.helloworld.repository;
import org.springframework.stereotype.Repository;
import com.example.helloworld.entity.Student; // Newly added import for Student entity
import org.springframework.data.jpa.repository.JpaRepository; // Newly added import for JpaRepository



@Repository

public interface HelloWorldRepository extends JpaRepository<Student, Long> { // Extending JpaRepository to manage Student entities

    // JpaRepository already provides basic CRUD operations, so no extra code is needed here.
}

