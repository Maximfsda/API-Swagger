package ru.hogwarts.school.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/{facultyId}")
    public Faculty getFaculty(@PathVariable("facultyId") long facultyId) {
        return facultyService.getFacultyById(facultyId);
    }

    @GetMapping("/color{color}")
    public Faculty getFacultyByAge(@PathVariable("color") String color) {
        return (Faculty) facultyService.getByColor(color);
    }

    @PutMapping("/{facultyId}")
    public Faculty updateFaculty(@PathVariable("facultyId") long facultyId, @RequestBody Faculty faculty) {
        return facultyService.updateFaculty(facultyId, faculty);
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable("facultyId") long facultyId) {
        facultyService.deleteFaculty(facultyId);
        return ResponseEntity.noContent().build();
    }


}

