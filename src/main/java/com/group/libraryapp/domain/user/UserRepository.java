package com.group.libraryapp.domain.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 상속받으면 @Repository 선언 필요 X
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByName(String name);
  // find: 1개 객체 or Optional<타입> 반환
  // By: where
  // findAll: 2개 이상 객체, List<타입>
  // exists: 쿼리 결과가 존재하는지 확인, boolean
  // count: 개수, long
  // NameAndAge: And
  // NameOrAge: Or
  // GreaterThan: 초과
  // GreaterThanEqual: 이상
  // LessThan: 미만
  // LessThanEqual: 이하
  // Between
  // StartsWith
  // EndsWith
}
