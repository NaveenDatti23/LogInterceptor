package com.example.intercept.dto;

import java.util.Map;
import lombok.Data;

@Data
public class RequestDto {

  private Object requestBody;

  private Map<String,String> headers;

}
