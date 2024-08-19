package com.SpringCrud.SpringCrud.Repository;

import com.SpringCrud.SpringCrud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
