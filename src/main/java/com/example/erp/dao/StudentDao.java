package com.example.erp.dao;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;

import java.util.List;

public interface StudentDao {
    boolean emailverify(Students students);
    List<Courses> coursesfetch(Students students);
}
