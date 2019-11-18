package com.sun.blog.dao;

import com.sun.blog.entity.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/13 19:57
 */
public interface TagDao extends JpaRepository<Tag , Long> {

    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
