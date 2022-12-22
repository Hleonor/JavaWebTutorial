package com.moc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletDemo05 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 路径的第一个“/”不能省略，他表示了当前项目
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        InputStream resourceAsStream_2 = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/moc/servlet/aa.properties");

        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        resp.getWriter().print(username + " : ");
        resp.getWriter().print(password + "\n");

        properties = new Properties();
        properties.load(resourceAsStream_2);
        username = properties.getProperty("username");
        password = properties.getProperty("password");

        resp.getWriter().print(username + " : ");
        resp.getWriter().print(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
