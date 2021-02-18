package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.dao.CRUDdao;
import com.sergeev.onlinetraining.dao.impl.UserDaoImpl;
import com.sergeev.onlinetraining.model.User;
import com.sergeev.onlinetraining.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author sea
 */
@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

    private final CourseService cs = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("courses", cs.getAll());
        req.getRequestDispatcher("courses.jsp").forward(req, resp);
    }

}
