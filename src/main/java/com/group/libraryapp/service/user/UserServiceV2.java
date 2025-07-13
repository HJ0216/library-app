package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequestRecord;
import com.group.libraryapp.dto.user.request.UserUpdateRequestRecord;
import com.group.libraryapp.dto.user.response.UserResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional // IOExceiption과 같은 Checked Exception은 rollback이 일어나지 X
@Service
@RequiredArgsConstructor
public class UserServiceV2 {

  private final UserRepository userRepository;

//  public UserServiceV2(UserRepository userRepository) {
//    this.userRepository = userRepository;
//  }

  public void saveUser(UserCreateRequestRecord request) {
    userRepository.save(new User(request.name(), request.age()));
  }

  @Transactional(readOnly = true)
  public List<UserResponse> getUsers() {
    return userRepository.findAll()
                         .stream()
                         .map(UserResponse::new)
                         .collect(Collectors.toList());
  }

  public void updateUser(UserUpdateRequestRecord request) {
    User user = userRepository.findById(request.id())
                              .orElseThrow(IllegalArgumentException::new);

    user.updateName(request.name());
//    userRepository.save(user); // 영속성 컨텍스트 안에서 불러와진 entity는 명시적으로 save하지 않아도 변경을 감지해 자동 저장
  }

  public void deleteUser(String name){
    User user =  userRepository.findByName(name)
        .orElseThrow(IllegalArgumentException::new); // Optional을 해제하고 진짜 User를 꺼내는 작업

    userRepository.delete(user);
  }
}
