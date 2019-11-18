package com.sun.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sunzt
 * @version 1.0
 * @date 2019/11/11 14:00
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptiongHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL : {}, exception : {}" , request.getRequestURL() , e);

        if (AnnotationUtils.findAnnotation(e.getClass() , ResponseStatus.class) != null) {
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url" , request.getRequestURL());
        mv.addObject("exception" , e);
        mv.setViewName("error/error");
        return mv;
    }
}
