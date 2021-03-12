package com.lomari.sturdysuccotash.handlers;

import com.lomari.sturdysuccotash.auth.ApplicationUser;
import com.lomari.sturdysuccotash.model.Customer;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {

        final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

        Principal principal = (Principal) authentication.getPrincipal();
        if (principal instanceof ApplicationUser){
            String role = ((ApplicationUser) principal).getRole();
            if(role.equalsIgnoreCase("admin")){
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/login");
            } else{
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
            }
        }
    }
}
