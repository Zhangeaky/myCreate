package com.zhangeaky.mycreate;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OldController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String id = request.getParameter("id");

        Cookie cookie = new Cookie("userId", "218812002000");
        response.addCookie(cookie);
        return null;
    }
}
