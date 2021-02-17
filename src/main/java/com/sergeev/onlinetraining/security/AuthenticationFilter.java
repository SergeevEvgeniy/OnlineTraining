package com.sergeev.onlinetraining.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    public static final String LOCATION = "/OnlineTraining/login";
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        LOG.info("Requested Resource::" + uri);

        HttpSession session = req.getSession(false);

        if (!req.getRequestURI().equals(LOCATION) && session == null) {
            LOG.info("Unauthorized access request");
            res.sendRedirect("/OnlineTraining/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
