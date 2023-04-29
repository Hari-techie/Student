package com.kgisl.studentCrudAngular;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        System.out.println("add student");
        System.out.println(student);
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        Student existingStudent = studentService.getById(id);

        existingStudent.setName(student.getName());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setAge(student.getAge());

        Student updateStudent = studentService.save(existingStudent);
        
        return updateStudent;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
