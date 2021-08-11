package com.jungle.spring.test.bean;

public class UserService {
    private String id;
    private UserDao userDao;


    public void queryUserInfo() {
        System.out.println("查询用户信息:" + userDao.queryUserName(id));
    }

    public UserService(String id, UserDao userDao) {
        this.id = id;
        this.userDao = userDao;
    }

    public UserService() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
