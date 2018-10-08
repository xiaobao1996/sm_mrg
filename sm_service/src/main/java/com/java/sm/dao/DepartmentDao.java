package com.java.sm.dao;

import com.java.sm.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("department")
public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(Integer id);
    Department select(Integer id);
    List<Department> selectAll();
}
