package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

  private String name;
  private Integer age; // null 허용일 경우, int가 아닌 Integer 잉용

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }
}
