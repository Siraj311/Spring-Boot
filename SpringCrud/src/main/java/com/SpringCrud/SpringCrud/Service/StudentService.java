package com.SpringCrud.SpringCrud.Service;

import com.SpringCrud.SpringCrud.Entity.Student;
import com.SpringCrud.SpringCrud.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student saveDetails(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllDetails() {
        return studentRepo.findAll();
    }

    public Student getStudentDetailsById(int id) {
        return studentRepo.findById(id).orElse(null);
    }
}
