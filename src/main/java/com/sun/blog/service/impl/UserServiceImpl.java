package com.sun.blog.service.impl;

import com.sun.blog.dao.UserDao;
import com.sun.blog.entity.User;
import com.sun.blog.service.UserService;
import com.sun.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/12 14:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username , MD5Utils.code(password));
        return user;
    }

}
