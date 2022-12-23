package com.moc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FileServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // * 要获取下载文件的路径
        //String realPath = this.getServletContext().getRealPath("D:\\JAVAWEB\\javaweb-02-servlet\\response\\target\\response-1.0-SNAPSHOT\\WEB-INF\\classes\\0031的推图.jpg");
        String realPath = "D:\\JAVAWEB\\javaweb-02-servlet\\response\\target\\response-1.0-SNAPSHOT\\WEB-INF\\classes\\0031的推图.jpg";
        System.out.println("获取下载文件的路径: " + realPath);

        // * 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);

        // * 设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西，用中文文件名编码，否则有可能乱码
        resp.setHeader("Content-Disposition", "attachment;filename" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        // * 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);

        // * 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];

        // * 获取outputstream对象
        ServletOutputStream out = resp.getOutputStream();

        // * 将FileOutputStream流写入到buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer)) > 0)
        {
            out.write(buffer, 0, len);
        }

        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
