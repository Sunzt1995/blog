package com.sun.blog.service;

import com.sun.blog.entity.User;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/12 14:48
 */
public interface UserService {

    User checkUser(String username , String password);
}
