package com.django.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
@Component
public class CookieFilter implements Filter {

    //private static final Logger LOGGER = Logger.getLogger(CookieFilter.class.getName());

    //@Autowired
    //private UserManager userManager;
 
    public CookieFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
 
        if(req.getCookies() != null){

        }
        else if (req.getAttribute("user") != null){
            // Cookie cookie = new Cookie("user", "toto");
            // ((Object) response).addCookie(cookie);
        }

        chain.doFilter(request, response);
    }
 
}