package com.sun.blog.dao;

import com.sun.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/12 14:59
 */

public interface UserDao extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username , String password);
}
