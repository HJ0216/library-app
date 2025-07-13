package com.group.libraryapp.repository.book;

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
