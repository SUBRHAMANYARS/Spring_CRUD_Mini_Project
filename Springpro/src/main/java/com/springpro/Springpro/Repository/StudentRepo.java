package com.springpro.Springpro.Repository;

import com.springpro.Springpro.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
