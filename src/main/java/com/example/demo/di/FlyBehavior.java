package com.example.demo.di;
//추상 - 미정이다, 결정되지 않다, 모른다
//인터페이스는 추상클래스보다 더 추상적이어서 오직 추상메소드만 가짐
//abstract 예약어를 생략할 수 있다.
public interface FlyBehavior {
	//메소드 선언인데 세미콜론으로 종료 = 추상메소드
	public abstract void fly();
}
