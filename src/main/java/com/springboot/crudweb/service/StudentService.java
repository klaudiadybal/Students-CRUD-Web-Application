package com.springboot.crudweb.service;

import com.springboot.crudweb.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student find(int id);

    void save(Student student);

    void delete(int id);
}
