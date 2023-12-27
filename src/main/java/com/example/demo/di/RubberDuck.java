package com.example.demo.di;

public class RubberDuck extends Duck {
	@Override
	public void swimming() {
		System.out.println("고무오리도 물 위에 뜬다!");
	}
	
	public RubberDuck() {
		//날고 있어요 - FlyWithWings.java > implements FlyBehavior
		//날 수 없어요 - FlyNoWay.java > implements FlyBehavior
		flyBehavior = new FlyNoWay(); // FlyBehavior의 구현체 클래스로 결정할 수 있음
	}

	@Override
	public void display() {
		System.out.println("나는 고무오리야!");
	}


}
