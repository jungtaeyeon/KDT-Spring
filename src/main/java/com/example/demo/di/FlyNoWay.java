package com.example.demo.di;
//implements는 그 추상 메소드를 재정의하는 것
//메소드 선언만 되어 있으므로 오리클래스가 되기 위한 명세서의 역할
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("나는 날지 않아!");
	}

}
