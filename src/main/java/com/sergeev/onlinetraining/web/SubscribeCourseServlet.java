package com.sergeev.onlinetraining.web;

import com.sergeev.onlinetraining.dto.UserDTO;
import com.sergeev.onlinetraining.model.Subscription;
import com.sergeev.onlinetraining.service.SubscriptionService;
import static com.sergeev.onlinetraining.web.LoginServlet.USER;
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
@WebServlet("/courses/subscribe")
public class SubscribeCourseServlet extends HttpServlet {
    
    private final SubscriptionService ss = new SubscriptionService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final UserDTO userDTO = (UserDTO) req.getSession().getAttribute(USER);
        Subscription subscription = new Subscription(
                userDTO.getUser().getId(),
                Integer.parseInt(req.getParameter("id"))
        );
        
        ss.create(subscription);
        resp.sendRedirect("/OnlineTraining/courses");
    }
}
