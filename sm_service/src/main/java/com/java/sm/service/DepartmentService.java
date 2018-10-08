package com.java.sm.service;

import com.java.sm.bean.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void edit(Department department);
    Department get(Integer id);
    void remove(Integer id);
    List<Department> getAll();
}
