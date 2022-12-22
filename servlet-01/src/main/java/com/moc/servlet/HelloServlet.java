package com.moc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet
{
    // 由于get或者post只是请求实现的不同方式，可以相互调用，业务逻辑都一样

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * 编写Servlet的映射：
     * 为什么需要映射︰我们写的是JAVA程序，但是要通过浏览器访问
     * 而浏览器需要连接web服务器，所以我们需要再web服务中注册我们写的Servlet
     * 还需给他一个浏览器能够访问的路径;
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("进入了doGet方法");
        PrintWriter writer = resp.getWriter(); // 响应流

        writer.println("Hello, Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPost(req, resp);
    }
}
