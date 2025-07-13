package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.request.BookCreateRequestRecord;
import com.group.libraryapp.dto.book.request.BookLoanRequestRecord;
import com.group.libraryapp.dto.book.request.BookReturnRequestRecord;
import com.group.libraryapp.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping("/book")
  public void saveBook(@RequestBody BookCreateRequestRecord request){
    bookService.saveBook(request);
  }

  @PostMapping("/book/loan")
  public void loanBook(@RequestBody BookLoanRequestRecord request){
    bookService.loanBook(request);
  }

  @PutMapping("/book/return")
  public void returnBook(@RequestBody BookReturnRequestRecord request){
    bookService.returnBook(request);
  }
}
