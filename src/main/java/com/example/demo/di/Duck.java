package com.example.demo.di;

import java.io.FileReader;
import java.util.Properties;

//추상클래스
//추상클래스는 추상메소드와 일반메소드를 모두 가짐
//생성자도 가짐
//변수선언 가능
//인터페이스는 일반메소드는 못 가짐
//추상클래스와 인터페이스의 공통점 = 둘 다 반드시 구현체 클래스가 있어야 함
//추상클래스의 구현체일 땐 extends 사용
//인터페이스의 구현체일 땐 implements 사용
public abstract class Duck {
	FlyBehavior flyBehavior = null;
	QuackBehavior quackBehavior = null;
  // 추클래스에 정의된 생성자가 직접 호출되는 구조가 아니라 
  // 자손 클래스가 호출될 때 부모 생성자를 먼저 호출한다. -> 그래야 전역변수 초기화가 된다.
  // 메소드 오버라이딩 규칙을 적용할 수 있다. - 언제?? 컴파일 타입에.
  // Duck myDuck = new MallardDuck();
	public Duck() {} 
		public abstract void display();
		public void performFly() {
			flyBehavior.fly();
		}
		public void performFlyQuack() {
			quackBehavior.quack();
		}
		public void swimming() {
			System.out.println("모든 오리는 물 위에 뜬다.");
		}

		
static Duck getDuck(int i){ // 객체를 제공하는 쪽
    // 메소드로 객체를 제공하는 쪽이 변경할 코드가 적다!
    return new RubberDuck();
  }
  static Duck getDuck(double d){ // 객체를 제공하는 쪽
    return new WoodDuck();
  }
  @SuppressWarnings("deprecation")
  static Object getObject(String key) throws Exception{
      Properties p = new Properties();
      // duckInfo.txt를 읽어서 Properties에 저장한다.
      p.load(new FileReader("duckInfo.txt"));
      // Class는 클래스 설계도를 얻어내는 클래스
      Class<?> clazz = Class.forName(p.getProperty(key)); // rubber, wood를 읽어서
    return clazz.newInstance();
  }
}
