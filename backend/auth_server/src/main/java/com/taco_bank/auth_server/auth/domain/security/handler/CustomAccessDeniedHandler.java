package com.taco_bank.auth_server.auth.domain.security.handler;

import com.taco_bank.auth_server.common.exception.ExceptionResponseWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("CustomAccessDeniedHandler - Exception Message: " + accessDeniedException.getMessage());
        ExceptionResponseWriter.writeExceptionResponse(response, HttpServletResponse.SC_FORBIDDEN, "Forbidden", "접근 권한이 없습니다.");
    }
}
