package com.example.demo.di;

public class DuckMain {
  
  public static void main(String[] args) {
    // 고무오리 타입이 호출되도록 해보시오.
    Duck duck = Duck.getDuck(1);
    if(duck instanceof RubberDuck){
      System.out.println("RubberDuck : "+duck);
    }

    Duck duck1 = Duck.getDuck(1.1);
    if(duck1 instanceof WoodDuck){
      System.out.println("WoodDuck : "+duck1);
    }
  }
}

/*
생성부 선언부가 같다...
객체를 사용하려는쪽
개발자가 수정해야할 코드가 많아짐.. - 문제제기
: 왜냐면 선언부와 생성부 모두 수정해야 함 - 생성자 오버로딩 - 전역변수 - 고유명사 - 모두 수정해야함
: 여기다가 이 제어권을 외부에서 갖자. -> 스프링 컨테이너 - IoC
기존방식의 문제점
컴포넌트간의 결합도가 높아서 컴포넌트 확장 및 재사용이 어려운 문제 발생시킴
IoC사용시
: 제어권 컨테이너에 넘어가 객체의 생명주기를 컨테이너가 전담하게 됨 - 빼앗김
Application
 * MallardDuck myDuck = new MallardDuck();
 * WoodDuck himDuck = new WoodDuck();
 */