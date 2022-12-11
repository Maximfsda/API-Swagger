package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/age{age}")
    public Student getStudentByAge(@PathVariable("age") int age) {
        return (Student) studentService.getByAge(age);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") long studentId, @RequestBody Student student) {
        return studentService.updateFaculty(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") long studentId) {
         studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }


}

