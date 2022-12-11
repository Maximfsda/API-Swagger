package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exeptions.StudentNotFoundExeption;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private Long counter = 1L;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Long facultyId,Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public Faculty getFacultyById(Long facultyId) {
        return facultyRepository.findById(facultyId).get();
    }

    public void deleteFaculty(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> getByColor(String color) {
        return facultyRepository.findAll();
    }
}
