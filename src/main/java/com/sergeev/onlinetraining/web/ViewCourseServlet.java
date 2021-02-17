package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.model.Course;
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
@WebServlet(urlPatterns = "/courses/view")
public class ViewCourseServlet extends HttpServlet {

    private static final String ID = "id";
    private static final String COURSE = "course";
    private final CourseService cs = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Course course = cs.getById(req.getParameter(ID));
        course.setTasks(cs.getTasks(course));
        req.setAttribute(COURSE, course);
        req.getRequestDispatcher("/viewCourse.jsp").forward(req, resp);
    }

}
