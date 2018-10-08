package com.java.sm.service.impl;

import com.java.sm.bean.Log;
import com.java.sm.dao.LogDao;
import com.java.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    public void addSystemLog(Log log) {
        log.setType("system");
        log.setOprTime(new Date());
        logDao.insert(log);
    }

    public void addLoginLog(Log log) {
        log.setType("login");
        log.setOprTime(new Date());
        logDao.insert(log);
    }

    public void addOperationLog(Log log) {
        log.setType("operation");
        log.setOprTime(new Date());
        logDao.insert(log);
    }

    public List<Log> getSystemLog() {
        return logDao.selectByType("system");
    }

    public List<Log> getLoginLog() {
        return logDao.selectByType("login");
    }

    public List<Log> getOperationLog() {
        return logDao.selectByType("operation");
    }
}
