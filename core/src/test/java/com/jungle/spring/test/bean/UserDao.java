package com.jungle.spring.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    public static Map<String, String> daoMap = new HashMap<>();

    static {
        daoMap.put("10001", "小傅哥");
        daoMap.put("10002", "八杯水");
        daoMap.put("10003", "阿毛");
    }

    public String queryUserName(String id) {
        return daoMap.get(id);
    }
}
