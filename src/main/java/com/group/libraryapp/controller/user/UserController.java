package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final List<User> users = new ArrayList<>();

  @PostMapping("/user") // POST /user
  public void saveUser(@RequestBody UserCreateRequest request) {
    users.add(new User(request.getName(), request.getAge()));
  }

  @GetMapping("/user")
  public List<UserResponse> getUsers() {
    List<UserResponse> userResponses = new ArrayList<>();

    int i=0;
    for (User user : users) {
      userResponses.add(new UserResponse(++i, user));
    }

    return userResponses;
  }

  // Getter가 있는 객체를 Controller에서 반환하면 JSON이 된다.
}
