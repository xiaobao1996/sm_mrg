package com.java.sm.service;

import com.java.sm.bean.Staff;

public interface SelfService {
    Staff login(String account,String password);
}
