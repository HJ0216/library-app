package com.group.libraryapp.dto.calculator.request;

public class CalculatorAddRequest {

  private final int number1;
  private final int number2;

  // Controller에서 자동 매핑이 되려면 query와 생성자 매개변수 이름이 동일해야 함
  public CalculatorAddRequest(int number1, int number2) {
    this.number1 = number1;
    this.number2 = number2;
  }

  public int getNumber1() {
    return number1;
  }

  public int getNumber2() {
    return number2;
  }
}
