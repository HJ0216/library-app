package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequestRecord;
import com.group.libraryapp.dto.user.request.UserUpdateRequestRecord;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceV1 {

  private final UserJdbcRepository userJdbcRepository;

//  public UserServiceV1(UserJdbcRepository userJdbcRepository) {
//    this.userJdbcRepository = userJdbcRepository;
//    this.userRepository = new UserJdbcRepository(jdbcTemplate);
//  }

  public void saveUser(UserCreateRequestRecord request) {
    userJdbcRepository.saveUser(request.name(), request.age());
  }

  public List<UserResponse> getUsers() {
    return userJdbcRepository.getUsers();
  }

  public void updateUser(UserUpdateRequestRecord request) {
    boolean isUserNotExist = userJdbcRepository.isUserNotExits(request.id());

    if(isUserNotExist) {
      throw new IllegalArgumentException();
    }

    userJdbcRepository.updateUserName(request.name(), request.id());
  }

  public void deleteUser(String name) {
    boolean isUserNotExist = userJdbcRepository.isUserNotExits(name);

    if(isUserNotExist) {
      throw new IllegalArgumentException();
    }

    userJdbcRepository.deleteUser(name);
  }
}
