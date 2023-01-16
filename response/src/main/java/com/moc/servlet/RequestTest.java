package com.moc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestTest extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("进入这个请求");
        // 处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " : " + password);

        // 重定向的时候一定要注意路径问题，否则会造成404
        resp.sendRedirect("/response/success.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
