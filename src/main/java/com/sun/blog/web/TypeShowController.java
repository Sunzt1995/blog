package com.sun.blog.web;

import com.sun.blog.entity.Type;
import com.sun.blog.service.BlogService;
import com.sun.blog.service.TypeService;
import com.sun.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/17 19:57
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 8 , sort = {"updateTime"} , direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model) {
        List<Type> types = typeService.listTypeTop(10000);
        if (id == -1) {
            id = types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types" , types);
        model.addAttribute("page" , blogService.listBlog(pageable ,blogQuery ));
        model.addAttribute("activeTypeId" , id);
        return "types";
    }
}
