package com.group.libraryapp.repository.book;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Primary
@Repository
public class BookMemoryRepository implements BookRepository {

//  private final List<Book> books = new ArrayList<Book>();

  @Override
  public void saveBook() {
    System.out.println("BookMemoryRepository.saveBook");
    // books.add(new Book());
  }
}
