package com.group.libraryapp.dto.user.request;

public record UserCreateRequestRecord(String name, Integer age) {
  // null 허용일 경우, int가 아닌 Integer 사용
}
