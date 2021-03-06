package com.sun.blog.dao;

import com.sun.blog.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/13 15:48
 */
public interface TypeDao extends JpaRepository<Type , Long> {

    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);

}
