package com.java.sm.service.impl;

import com.java.sm.bean.Department;
import com.java.sm.dao.DepartmentDao;
import com.java.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department get(Integer id) {
        return departmentDao.select(id);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
