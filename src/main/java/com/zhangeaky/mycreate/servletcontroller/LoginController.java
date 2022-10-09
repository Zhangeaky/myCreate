package com.zhangeaky.mycreate.servletcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {



    @RequestMapping(value = "/v1/cookie")
    public void register(HttpServletRequest request, HttpServletResponse response, ModelMap map) {

        if (request.getCookies().length > 0) {
            Cookie cookie = request.getCookies()[0];
            String.format("version %s // name: %s ", cookie.getVersion(), cookie.getName());
            System.out.println(cookie.getVersion());
            //request.getSession(request.getCookies()[0].get)
        }

        System.out.println("nihao");
        request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("name", "yida");
        Cookie cookie = new Cookie("name", "zhangyikai.zyk");
        response.addCookie(cookie);
    }


}
