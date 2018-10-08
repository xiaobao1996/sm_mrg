package com.java.sm.service.impl;

import com.java.sm.bean.Staff;
import com.java.sm.dao.SelfDao;
import com.java.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfDao selfDao;
    public Staff login(String account,String password) {
        Staff staff = selfDao.selectByAccont(account);
        if(staff.getPassword().equals(password)){
            return staff;
        }else {
            return null;
        }

    }
}
