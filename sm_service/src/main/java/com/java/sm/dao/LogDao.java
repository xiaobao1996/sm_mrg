package com.java.sm.dao;

import com.java.sm.bean.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("log")
public interface LogDao {
    void insert(Log log);
    List<Log> selectByType(String type);
}
