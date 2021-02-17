package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.dto.UserDTO;
import com.sergeev.onlinetraining.model.User;
import com.sergeev.onlinetraining.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author sea
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static final String USER = "user";
    private static final String USER_NAME = "userName";

    private final UserService us = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        User user = us.getByEmail(email);

        if (user != null && user.getPassword().equals(pwd)) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie(USER_NAME, user.getNickname());
            userName.setMaxAge(30 * 60);

            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }

            session.setAttribute(USER_NAME, userName);
            session.setAttribute(USER, new UserDTO(user));
            session.setAttribute("sessionID", sessionID);

            response.addCookie(userName);
            response.sendRedirect("/OnlineTraining/courses");

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>User name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
