package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.model.Task;
import com.sergeev.onlinetraining.service.CourseService;
import com.sergeev.onlinetraining.service.TaskService;
import com.sergeev.onlinetraining.service.UserService;
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
@WebServlet(urlPatterns = "/courses/tasks/create")
public class CreateTaskServlet extends HttpServlet {

    private final UserService us = new UserService();
    private final CourseService cs = new CourseService();
    private final TaskService ts = new TaskService();

    private String courseId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseId = req.getParameter("courseid");

        req.setAttribute("lectors", us.getLectors());
        req.getRequestDispatcher("/createTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Task task = new Task(
                req.getParameter("Task_name"),
                req.getParameter("Task_description"),
                cs.getById(courseId));

        ts.create(task);
        resp.sendRedirect("/OnlineTraining/courses/edit?id=" + courseId);
    }

}
