package com.moc.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // this.getInitParameter();     初始化参数
        // this.getServletConfig();     Servlet配置
        // this.getServletContext();    Servelt上下文
        /**
         * Web容器在启动的时候，它会为每个web程序都创建一个对应的ServletContext对象
         * 它代表了当前的web应用
         * 如，共享数据：我在这Servlet中保存的数据，可以在另一个Servlet中拿到
         */
        ServletContext servletContext = this.getServletContext();

        String username = "Sekiro"; // data
        servletContext.setAttribute("username", username); // 将一个数据保存到上下文中，名字为username，值为'username'

        System.out.println("Hello");
    }
}
