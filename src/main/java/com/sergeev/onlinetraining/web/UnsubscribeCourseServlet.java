package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.dto.UserDTO;
import com.sergeev.onlinetraining.model.Subscription;
import com.sergeev.onlinetraining.service.SubscriptionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author sea
 */
@WebServlet("/courses/unsubscribe")
public class UnsubscribeCourseServlet extends HttpServlet {

    private final SubscriptionService ss = new SubscriptionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO user = (UserDTO) req.getSession().getAttribute(LoginServlet.USER);
        List<Subscription> subscriptions = user.getSubscriptions();
        Integer courseId = Integer.parseInt(req.getParameter("id"));
        Integer subId = 0;

        for (Subscription sub : subscriptions) {
            if (sub.getCourseId() == courseId) {
                subId = sub.getId();
                break;
            }
        }
        ss.delete(subId);
        resp.sendRedirect("/OnlineTraining/courses");
    }
}
