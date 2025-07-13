package com.group.libraryapp.domain.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
  Optional<UserLoanHistory> findByBookNameAndIsReturn(String name, boolean isReturn);
  boolean existsByBookNameAndIsReturn(String name, boolean isReturn);
//  Optional<UserLoanHistory> findByUserIdAndBookName(Long userId, String bookName);
}
