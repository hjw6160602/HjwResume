package com.wj.hr.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet {
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("website - admin777");

    }
}
