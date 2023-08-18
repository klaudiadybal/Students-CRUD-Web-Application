package com.springboot.crudweb.service;

import com.springboot.crudweb.dao.StudentRepository;
import com.springboot.crudweb.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
    }
}
