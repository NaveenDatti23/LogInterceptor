package com.example.intercept.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Logservice {

  @Autowired
  private ObjectMapper objectMapper;

  public void printRequest(Map<String,String> headers, Object requestBody) {
      headers.forEach((key, value) -> {
        System.out.println(String.format("Header '%s' = %s", key, value));
      });
      if (Objects.nonNull(requestBody)) {
        System.out.println("Request Body is " + requestBody.toString());
      }
    }

    public void logRequestHeaders(HttpServletRequest request) {

      if (request.getHeader("referer") != null) {
          Map<String,String> headers = getHeadersMap(request);
          headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
          });
      }
    }

    public void logRequestBody(HttpServletRequest request, Object body) {
      if (request.getHeader("referer") != null) {
        try {
          System.out.println(objectMapper.writeValueAsString(body));
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }
      }
    }

  private final Map<String, String> getHeadersMap(HttpServletRequest request) {
    Map<String, String> map = new HashMap<>();

    Enumeration headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
        String value = request.getHeader(key);
        map.put(key, value);
    }
    return map;
  }

  }
