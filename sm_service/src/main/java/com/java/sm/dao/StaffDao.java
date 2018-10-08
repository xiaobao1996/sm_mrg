package com.java.sm.dao;

import com.java.sm.bean.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("staff")
public interface StaffDao {
    void insert(Staff staff);
    void update(Staff staff);
    void delete(Integer id);
    Staff select(Integer id);
    List<Staff> selectAll();
}
