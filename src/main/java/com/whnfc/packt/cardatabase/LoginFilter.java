package com.whnfc.packt.cardatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whnfc.packt.cardatabase.domain.AccountCredentials;
import com.whnfc.packt.cardatabase.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException,
            ServletException {

        //从request中获取username和password
        AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
//        AccountCredentials creds = new AccountCredentials();
//        creds.setUsername(req.getParameter("username"));
//        creds.setPassword(req.getParameter("password"));
        //request auth token
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword(),
                Collections.emptyList());
        //认证
        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        //认证成功后，将token添加到response head中
        AuthenticationService.addToken(res, auth.getName());
    }
}