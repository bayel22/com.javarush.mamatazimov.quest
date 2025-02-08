package com.javarush.mamatazimov.quest.controller;

import java.io.*;

import com.javarush.mamatazimov.quest.entity.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

    }

    public void destroy() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String sessionId = session.getId();

        request.setAttribute("sessionID", sessionId);


        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }


        User user = (User) session.getAttribute("user");
        response.getWriter().println("Добро пожаловать в квест, " + user.getName() + "!");

    }
}