package com.sun.blog.service;

import com.sun.blog.entity.Comment;

import java.util.List;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/16 21:15
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
