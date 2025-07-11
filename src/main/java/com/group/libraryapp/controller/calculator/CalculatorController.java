package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스를 API의 진입 지점으로 지정
public class CalculatorController {

//  @GetMapping("/add") // GET /add
//  public int addTwoNumbers(@RequestParam int number1, @RequestParam int number2) {
//    return number1 + number2;
//  }

  @GetMapping("/add") // GET /add
  public int addTwoNumbers(CalculatorAddRequest request) {
    return request.getNumber1() + request.getNumber2();
  }

  @PostMapping("/multiply") // POST /multiply
  public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) { // RequestBody: JSON -> DTO
    return request.getNumber1() * request.getNumber2();
  }

}
