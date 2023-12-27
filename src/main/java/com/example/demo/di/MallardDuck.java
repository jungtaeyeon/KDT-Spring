package com.example.demo.di;

public class MallardDuck extends Duck {
  MallardDuck(){
    // 의존관계
    // 선언부에는 추상클래스나 인터페이스가 오고 대입연산자 뒤에는 구현체 클래스가 온다.
    // 유연하다 - 확장성, 재사용성 증가, 코딩양도 줄어든다. 왜냐면 생성부 이름만 바꿔주면 되니까!
    // 선언부는 고치지 않아도 된다. -> 유연성
    // IoC - 결합도 낮추기 위한
    flyBehavior = new FlyWithWings();
    quackBehavior = new Quack();
  }

  @Override
  public void display() {
    System.out.println("나는 청둥오리 입니다.");
  }
}
