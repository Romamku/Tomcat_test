package dev.romamk.tomcat.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(HelloWorldServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        logger.info("HelloWorldServlet was inited!");
    }

    @Override
    public void destroy() {
        super.destroy();
        logger.info("HelloWorldServlet was destroyed!");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //в качестве ответа отправляем HTML страничку с текстом
        logger.info("Request: {}", request);

        try (PrintWriter out = response.getWriter()) {
            String title = "HelloWorld!";
            out.println("<!DOCTYPE html>");  // HTML 5
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>" + title + "</title></head>");
            out.println("<body>");
            out.println("<h1>" + title + "</h1>");  // Prints "Hello, world!"
            out.println("<a href='" + request.getRequestURI() + "'><img src='images/return.gif'></a>" +
                    "<img src='images/return1.gif'></a>");
            out.println("</body></html>");
        }
    }
}