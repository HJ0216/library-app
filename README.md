### 어노테이션을 사용하는 이유 (효과) 는 무엇일까?
1. 코드 문서화와 가독성 향상
```java
class Animal {
    public void sound(){
        System.out.println("소리");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
```
2. 컴파일 타임 체크와 안전성 보장
```java
class Animal {
    public void sound(){
        System.out.println("소리");
    }
}

class Dog extends Animal {
    @Override
    public void soud() { // compile error
        System.out.println("멍멍");
    }
}
```
3. 런타임 처리와 동적 기능 추가
```java
class BookService {
    public void printBook() {
        System.out.println("책 출력!");
    }
}

@Component
class BookController {
    private final BookService bookService;

    public BookController() {
        this.bookService = new BookService(); // 직접 생성, 스프링의 제어 역전(IoC) 원칙 위반
    }

    public void doSomething() {
        bookService.printBook();
    }
}

@Component
class BookController {
    private final BookService bookService;

    @Autowired // Spring 컨테이너가 런타임에 자동으로 의존성을 주입(Injection)
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void doSomething() {
        bookService.printBook();
    }
}
```

4. 자신만의 어노테이션을 정의하여 도메인 특정 기능을 확장 가능



### 참고 자료
[자바의 Annotation 에 대해서](https://www.inflearn.com/blogs/6509?srsltid=AfmBOoqjhvbV0OA4THgQyj1_KT8bFSOrB_r_pHXtxXSwUsDMsl4z78it)  
[Annotation](https://github.com/rhoeunbin/TIL/blob/aa35ead5767aff88ea61ed828fb1698111ffdf2e/Spring/Annotation.md?plain=1#L4)  