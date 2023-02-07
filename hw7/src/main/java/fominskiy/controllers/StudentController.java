package fominskiy.controllers;

import fominskiy.models.Student;
import fominskiy.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> showAll() {
        return service.showAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveNewStudent(@RequestBody Student student) {
        student.setId(null);
        return service.saveOrUpdate(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return service.saveOrUpdate(student);
    }


}
