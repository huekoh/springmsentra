package com.example.springmsentra.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("Admin"))) {
            response.sendRedirect("/add-appeal");
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("User"))) {
            response.sendRedirect("/verify-appeal");
        } else {
            response.sendRedirect("/appeal-processing");
        }
    }
}

