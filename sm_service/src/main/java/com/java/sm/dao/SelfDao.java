package com.java.sm.dao;

import com.java.sm.bean.Staff;
import org.springframework.stereotype.Repository;

@Repository("self")
public interface SelfDao {
    Staff selectByAccont(String account);
}
