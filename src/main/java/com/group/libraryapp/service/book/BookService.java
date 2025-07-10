package com.group.libraryapp.service.book;

import com.group.libraryapp.repository.book.BookMemoryRepository;
import com.group.libraryapp.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;

  // 빈 주입 방식: 생성자(권장)
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
    // 어떤 bookRepository를 쓸꺼냐,
    // @Primary를 쓰거나
    // 매개변수에 @Qualifier("bookMemoryRepository")로 선택해서 가져올 수 있음
    // 또는 @Qualifier("main")으로 선언할 경우, @Qualifier("main")으로 선언한 Repository가 있으면 해당 repo 부름
    // 우선순위 @Qualifier > @Primary
  }

  // 빈 주입 방식2: setter + @Autowired -> 누군가 Setter를 사용할 수 있으므로 위험
  // 빈 주입 방식3: 필드 + @Autowired -> 테스트 코드 작성 어려움

  public void saveBook() {
    bookRepository.saveBook();
  }
}
