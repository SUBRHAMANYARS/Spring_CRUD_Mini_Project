package com.springpro.Springpro.Service;


import com.springpro.Springpro.Entity.Student;
import com.springpro.Springpro.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepo studentRepo;


    public Student saveDetails(Student student){
        return studentRepo.save(student);

    }


    public Student getDetailsById(int id){

        return studentRepo.findById( id).orElse(null);
    }

    public List<Student> getAllDetails(){

        return studentRepo.findAll();
    }

    public Student updateDetails(Student student){
        Student updateStudent= studentRepo.findById(student.getId()).orElse(null);

         if(updateStudent!=null){
            updateStudent.setMark(student.getMark());
            updateStudent.setName(student.getName());
            studentRepo.save(updateStudent);
            return updateStudent;
        }
            return null;
    }

    public String deleteStudent(int id){
        if(studentRepo.existsById(id)){
        studentRepo.deleteById(id);
        return "deleted "+id;
        }
        else{
        return "id not there";
        }
    }


    public List<Student> saveAllDetails(List<Student> students){
        return studentRepo.saveAll(students);
    }

}
