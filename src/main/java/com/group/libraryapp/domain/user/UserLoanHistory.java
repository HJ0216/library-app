package com.group.libraryapp.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserLoanHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;
//  @Column(nullable = false)
//  private Long userId;

  @ManyToOne
  private User user;

  @Column(nullable = false)
  private String bookName;
  @Column(nullable = false)
  private boolean isReturn; // tinyint(1)

  public UserLoanHistory(User user, String bookName) {
    this.user = user;
    this.bookName = bookName;
    this.isReturn = false;
  }

  public boolean isReturn() {
    return isReturn;
  }

  public void doReturn() {
    this.isReturn = true;
  }
}
