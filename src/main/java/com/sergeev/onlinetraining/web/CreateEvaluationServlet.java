package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.dto.UserDTO;
import com.sergeev.onlinetraining.model.Evaluation;
import com.sergeev.onlinetraining.service.EvaluationService;
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
@WebServlet(urlPatterns = "/courses/tasks/evaluation/create")
public class CreateEvaluationServlet extends HttpServlet {

    private final UserService us = new UserService();
    private final TaskService ts = new TaskService();
    private final EvaluationService es = new EvaluationService();

    private String taskId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        taskId = req.getParameter("taskid");

        req.setAttribute("students", us.getStudents());
        req.getRequestDispatcher("/createEvaluation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");
        Evaluation e = new Evaluation(
                Integer.parseInt(req.getParameter("grade_value")),
                req.getParameter("comment"),
                ts.getById(taskId),
                us.getById(req.getParameter("students")),
                userDTO.getUser());

        es.create(e);
        resp.sendRedirect("/OnlineTraining/courses/tasks/view?id=" + taskId);
    }

}
