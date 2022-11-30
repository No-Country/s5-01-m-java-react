package com.fourjuniors.juniors.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourjuniors.juniors.model.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("token not found or invalid");

        MessageDto messageDto = new MessageDto(HttpStatus.UNAUTHORIZED, "token not found or invalid");

        response.setContentType("application/json");
        response.setStatus(messageDto.getStatus().value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(messageDto));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
