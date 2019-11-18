package com.sun.blog.service;

import com.sun.blog.entity.Blog;
import com.sun.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/14 14:12
 */
public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable , BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId , Pageable pageable);

    Page<Blog> listBlog(String query , Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String , List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id , Blog blog);

    void deleteBlog(Long id);
}
