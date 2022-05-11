package com.example.intercept.interceptors;

import com.example.intercept.services.Logservice;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class RequestInterceptor implements HandlerInterceptor {

  @Autowired
  private Logservice logservice;

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response, Object object) throws Exception {
    request.setAttribute("requestStartTime", System.currentTimeMillis());
    logservice.logRequestHeaders(request);
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object object, Exception arg3)
      throws Exception {
    long executeTime = System.currentTimeMillis() - (Long)request.getAttribute("requestStartTime");
    System.out.println("Time taken for request is " + executeTime + " milliseconds");
  }
}


