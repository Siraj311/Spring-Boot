package com.SpringCrud.SpringCrud.Controller;

import com.SpringCrud.SpringCrud.Entity.Student;
import com.SpringCrud.SpringCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/addStudent")
    public Student postDetails(@RequestBody Student student) {
        return studentService.saveDetails(student);
    }

    @GetMapping("/getStudent")
    public List<Student> getDetails() {
        return studentService.getAllDetails();
    }

    @GetMapping("/getStudentByID/{id}")
    public Student fetchDetailsById(@PathVariable int id) {
        return studentService.getStudentDetailsById(id);
    }
}
