package com.group.libraryapp.dto.user.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {

  private String name;
  private Integer age; // null 허용일 경우, int가 아닌 Integer 잉용
}
