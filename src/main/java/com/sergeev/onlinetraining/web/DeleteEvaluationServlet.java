package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.model.Evaluation;
import com.sergeev.onlinetraining.service.EvaluationService;
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
@WebServlet("/courses/tasks/evaluation/delete")
public class DeleteEvaluationServlet extends HttpServlet {

    private final EvaluationService es = new EvaluationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Evaluation e = es.getById(req.getParameter("gradeid"));
        es.delete(e);
        resp.sendRedirect("/OnlineTraining/courses/tasks/view?id=" + req.getParameter("taskid"));
    }

}
