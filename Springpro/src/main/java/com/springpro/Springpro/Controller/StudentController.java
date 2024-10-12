package com.springpro.Springpro.Controller;


import com.springpro.Springpro.Entity.Student;
import com.springpro.Springpro.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE
    // http://localhost:8080/addStudent
    @PostMapping("/addStudent")
    public Student postDetails(@RequestBody Student student){
        return studentService.saveDetails(student);
    }


//        public String postDetails(@RequestBody Student student){
//         studentService.saveDetails(student);
//         return "Posted";
//    }

    // READ/RETRIEVE BY ID
    // http://localhost:8080/getStudentById/1
    @GetMapping("/getStudentById/{id}")
    public Student fetchDetailsByid(@PathVariable int id) {
        return studentService.getDetailsById(id);
    }


    // READ/RETRIEVE
    //http://localhost:8080/getStudent
    @GetMapping("/getStudent")
    public List<Student> getDetails(){
       return studentService.getAllDetails();
    }

    // UPDATE
    //http://localhost:8080/updateStudent
    @PutMapping("/updateStudent")
    public Student updateStudetnDetails(@RequestBody Student student){
      return studentService.updateDetails(student);
    }


    //DELETE
    //http://localhost:8080/delete/1
    @DeleteMapping("/delete/{id}")
    public String deletreStudent(@PathVariable int  id){
        return studentService.deleteStudent(id);
    }


    //CREATE MANY RECORDS
    //http://localhost:8080/addStudentList
    @PostMapping("/addStudentList")
    public List<Student> postDetails(@RequestBody List<Student>  students){
        return studentService.saveAllDetails(students);
    }
}
