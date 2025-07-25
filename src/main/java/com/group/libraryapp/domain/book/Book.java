package com.group.libraryapp.domain.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  @Column(nullable = false)
  private String name;

  public Book(String name) {
    if (name == null || name.isEmpty()) {
      throw new NullPointerException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
    }
    this.name = name;
  }
}
