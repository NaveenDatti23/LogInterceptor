package com.example.intercept.logconfig;

import com.example.intercept.services.Logservice;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

@ControllerAdvice
public class LogRequest implements RequestBodyAdvice {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    Logservice logservice;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type,
        Class<? extends HttpMessageConverter<?>> aClass) {
      return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter,
        Type targetType, Class<? extends HttpMessageConverter<?>> converterType)
        throws IOException {
      return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
        MethodParameter parameter, Type targetType,
        Class<? extends HttpMessageConverter<?>> converterType) {
      logservice.logRequestBody(httpServletRequest, body);

      return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage,
        MethodParameter parameter, Type targetType,
        Class<? extends HttpMessageConverter<?>> converterType) {
      return body;
    }
  }

