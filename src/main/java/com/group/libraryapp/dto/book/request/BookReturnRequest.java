package com.group.libraryapp.dto.book.request;

public class BookReturnRequest {
  // dto spec이 변경될 수 있으므로 동일한 req가 있더라도 각각 생성

  private String userName;
  private String bookName;

  public String getUserName() {
    return userName;
  }

  public String getBookName() {
    return bookName;
  }
}
