package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.model.Task;
import com.sergeev.onlinetraining.service.TaskService;
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
@WebServlet("/courses/tasks/delete")
public class DeleteTaskServlet extends HttpServlet {

    TaskService ts = new TaskService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Task task = ts.getById(req.getParameter("taskid"));
        ts.delete(task);
        resp.sendRedirect("/OnlineTraining/courses/edit?id=" + req.getParameter("courseid"));
    }
}
