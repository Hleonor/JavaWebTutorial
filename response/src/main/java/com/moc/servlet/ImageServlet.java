package com.moc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 如何让浏览器5秒自动刷新一次
        resp.setHeader("refresh", "3");

        // 在内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        // 得到图片，将getGraphics当作一支笔
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        // 设置图片的背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 80, 20);
        // 给图片写数据
        graphics.setColor(Color.blue);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(makeNum(), 0, 20);

        // 告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/png");
        // 网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires", -1);
        // 告诉浏览器不缓存
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        // 把图片写给浏览器
        boolean write = ImageIO.write(image, "png",resp.getOutputStream());

    }

    // 生成随机数
    private String makeNum()
    {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++)
        {
            sb.append("0"); // 如果生成是随机数位数小于7位，则自动填充0
        }
        num += sb.toString();
        return num;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
