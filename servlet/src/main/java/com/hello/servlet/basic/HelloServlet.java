package com.hello.servlet.basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String userName = request.getParameter("userName");
        System.out.println("userName = " + userName);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        response.getWriter().write("{ \"hello\" : \"" + userName + "\" }");
    }

}
