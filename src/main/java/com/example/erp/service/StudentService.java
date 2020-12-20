package com.example.erp.service;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.dao.StudentDao;
import com.example.erp.dao.implementation.StudentDaoImpl;

import java.util.List;

public class StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    public boolean verifyEmail(Students students){
        return studentDao.emailverify(students);
    }
    public List<Courses> getCourses(Students students){
        return studentDao.coursesfetch(students);
    }

}
