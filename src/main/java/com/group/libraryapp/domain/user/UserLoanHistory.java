package com.group.libraryapp.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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

  protected UserLoanHistory() {}

  public UserLoanHistory(User user, String bookName) {
    this.user = user;
    this.bookName = bookName;
    this.isReturn = false;
  }



  public Long getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public String getBookName() {
    return bookName;
  }

  public boolean isReturn() {
    return isReturn;
  }

  public void doReturn() {
    this.isReturn = true;
  }
}
