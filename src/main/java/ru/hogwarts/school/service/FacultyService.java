package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exeptions.StudentNotFoundExeption;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private Map<Long, Faculty>  facultys = new HashMap<>();
    private Long counter = 1L;

    public Faculty createFaculty(Faculty faculty) {
        facultys.put(counter, faculty);
        counter++;
        return faculty;
    }

    public Faculty updateFaculty(Long facultyId,Faculty faculty) {
        if(this.facultys.containsKey(facultyId)){
            Faculty oldFaculty = this.facultys.get(facultyId);
            oldFaculty.setName(faculty.getName());
            oldFaculty.setColor(faculty.getColor());
            return oldFaculty;
        }
        else {
            throw new StudentNotFoundExeption();
        }
    }
    public Faculty getFacultyById(Long facultyId) {
        if(this.facultys.containsKey(facultyId)){
            return this.facultys.get((facultyId));
        }
        else {
            throw new StudentNotFoundExeption();
        }
    }

    public Faculty deleteFaculty(Long facultyId) {
        if(this.facultys.containsKey(facultyId)){
            return facultys.remove(facultyId);
        }
        else {
            throw new StudentNotFoundExeption();
        }
    }

    public Collection<Faculty> getByColor(String color) {
        return this.facultys.values()
                .stream()
                .filter(s->s.getColor() == color)
                .collect(Collectors.toList());
    }
}
