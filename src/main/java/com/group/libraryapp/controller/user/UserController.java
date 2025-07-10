package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;
//  private final JdbcTemplate jdbcTemplate;

  public UserController(UserService userService) {
    this.userService = userService;
//    this.jdbcTemplate = jdbcTemplate;
//    userService = new UserService(jdbcTemplate);
  }

  //  private final List<User> users = new ArrayList<>();

  @PostMapping("/user") // POST /user
  public void saveUser(@RequestBody UserCreateRequest request) {
    userService.saveUser(request);
//    users.add(new User(request.getName(), request.getAge()));
  }

  @GetMapping("/user")
  public List<UserResponse> getUsers() {
    return userService.getUsers();
//    List<UserResponse> userResponses = new ArrayList<>();
//
//    int i = 0;
//    for (User user : users) {
//      userResponses.add(new UserResponse(++i, user));
//    }
//
//    return userResponses;
  }

  @PutMapping("/user")
  public void updateUser(@RequestBody UserUpdateRequest request) {
    userService.updateUser(request);
  }

  @DeleteMapping("/user")
  public void deleteUser(@RequestParam String name){
    userService.deleteUser(name);
  }

  // Getter가 있는 객체를 Controller에서 반환하면 JSON이 된다.
}
