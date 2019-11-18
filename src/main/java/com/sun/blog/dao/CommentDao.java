package com.sun.blog.dao;

import com.sun.blog.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/16 21:17
 */
public interface CommentDao extends JpaRepository<Comment , Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId , Sort sort);

}
