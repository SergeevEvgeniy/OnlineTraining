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
@WebServlet(urlPatterns = "/courses/tasks/view")
public class ViewTaskServlet extends HttpServlet {

    private static final String ID = "id";
    private static final String TASK = "task";
    private static final String GRADE = "grades";
    private final TaskService ts = new TaskService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Task task = ts.getById(req.getParameter(ID));

        req.setAttribute(TASK, task);
        req.setAttribute(GRADE, ts.getGrades(task));
        req.getRequestDispatcher("/viewTask.jsp").forward(req, resp);
    }

}
