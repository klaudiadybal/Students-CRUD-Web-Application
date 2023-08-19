package com.springboot.crudweb.controller;

import com.springboot.crudweb.entity.Student;
import com.springboot.crudweb.service.StudentService;
import com.springboot.crudweb.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/saveForm")
    public String showSaveForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "form";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, Errors errors){

        if(!errors.hasErrors()){
            studentService.save(student);
            return "redirect:/students/list";
        }
        return "form";
    }

    @GetMapping("/updateForm")
    public String showUpdateForm(@RequestParam("id") int id, Model model){

        Student student = studentService.find(id);
        model.addAttribute("student", student);

        return "form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        studentService.delete(id);

        return "redirect:/students/list";
    }
}
