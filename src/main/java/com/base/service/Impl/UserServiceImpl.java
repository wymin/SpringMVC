package com.base.service.Impl;

import com.base.dao.UserDao;
import com.base.pojo.User;
import com.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("userService")
public class UserServiceImpl implements UserService {

    //@Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
