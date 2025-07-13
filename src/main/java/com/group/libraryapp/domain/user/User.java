package com.group.libraryapp.domain.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql auto-increment
  private Long id = null;

  @Column(nullable = false, length = 20, name = "name") // name varchar(20)
  private String name;

  @Column(nullable = false)
  private Integer age;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  // orphanRemoval: 객체간 관계가 끊어진 데이터를 자동으로 제거하는 옵션, 부모 컬렉션에서 제거된 자식 엔티티가 자동으로 DB에서 삭제
  // FetchType.Lazy: 지연 로딩, 연관된 엔티티에 실제로 접근하는 시점에 필요한 데이터를 조회하는 방식
  private List<UserLoanHistory> histories = new ArrayList<UserLoanHistory>();

  public User(String name, Integer age) {

    if(name == null || name.isBlank())
      throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));

    this.name = name;
    this.age = age;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public void loanBook(String bookName){
    this.histories.add(new UserLoanHistory(this, bookName));
  }

  public void returnBook(String bookName){
    UserLoanHistory loanHistory = this.histories.stream()
                                                .filter(history -> history.getBookName().equals(bookName))
                                                .findFirst()
                                                .orElseThrow(IllegalArgumentException::new);
    loanHistory.doReturn();
  }
}
