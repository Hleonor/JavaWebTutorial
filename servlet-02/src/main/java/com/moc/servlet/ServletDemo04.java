package com.moc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletDemo04 extends HelloServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ServletContext servletContext = this.getServletContext();
        System.out.println("进入了ServletDemo04");

        // 转发的请求路径
        // RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getParameter");
        // 调用forward实现请求转发
        // requestDispatcher.forward(req, resp);
        servletContext.getRequestDispatcher("/getParameter").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
