package com.group.libraryapp.dto.book.request;

public record BookReturnRequestRecord(String userName, String bookName) {
  // dto spec이 변경될 수 있으므로 동일한 req가 있더라도 각각 생성
}
