package com.springboot.crudweb.controller;

import com.springboot.crudweb.entity.Student;
import com.springboot.crudweb.service.StudentService;
import com.springboot.crudweb.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getStudents(Model model) {
        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        return "students";
    }
}
