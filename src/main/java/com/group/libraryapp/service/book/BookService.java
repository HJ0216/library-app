package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserLoanHistory;
import com.group.libraryapp.domain.user.UserLoanHistoryRepository;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookService {

  private final BookRepository bookRepository;
  private final UserLoanHistoryRepository userLoanHistoryRepository;
  private final UserRepository userRepository;

  // 빈 주입 방식: 생성자(권장)
  public BookService(BookRepository bookRepository,
      UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
    this.bookRepository = bookRepository;
    // 어떤 bookRepository를 쓸꺼냐,
    // @Primary를 쓰거나
    // 매개변수에 @Qualifier("bookMemoryRepository")로 선택해서 가져올 수 있음
    // 또는 @Qualifier("main")으로 선언할 경우, @Qualifier("main")으로 선언한 Repository가 있으면 해당 repo 부름
    // 우선순위 @Qualifier > @Primary
    this.userLoanHistoryRepository = userLoanHistoryRepository;
    this.userRepository = userRepository;
  }

  // 빈 주입 방식2: setter + @Autowired -> 누군가 Setter를 사용할 수 있으므로 위험
  // 빈 주입 방식3: 필드 + @Autowired -> 테스트 코드 작성 어려움

  public void saveBook(BookCreateRequest request) {
    bookRepository.save(new Book(request.getName()));
  }

  public void loanBook(BookLoanRequest request) {
    // 1. 책 정보
    bookRepository.findBookByName(request.getBookName())
        .orElseThrow(IllegalArgumentException::new);

    // 2. 대출 확인
    // 3. 대출 중 - 예외 처리
    if(userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false)){
      throw new IllegalArgumentException("Book already loaned!");
    }

    // 4. 유저 정보
    // 5. 대출 데이터 추가
    User user = userRepository.findByName(request.getUserName())
                              .orElseThrow(IllegalArgumentException::new);

    user.loanBook(request.getBookName());
//    userLoanHistoryRepository.save(new UserLoanHistory(user, request.getBookName()));
  }

  public void returnBook(BookReturnRequest request) {
    // 1. 유저 정보
    User user = userRepository.findByName(request.getUserName())
                              .orElseThrow(IllegalArgumentException::new);

    user.returnBook(request.getBookName());
    // 2. 대출 기록
//    UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(
//        user.getId(), request.getBookName()).orElseThrow(IllegalArgumentException::new);

    // 3. 반납
//    history.doReturn();
  }
}
