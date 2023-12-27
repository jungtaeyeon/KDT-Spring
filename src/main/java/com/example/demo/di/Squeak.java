package com.example.demo.di;

public class Squeak implements QuackBehavior {
	//추상메소드를 재정의하는 것
	@Override
	public void quack() {
		System.out.println("꾸에에에에엑!!!!");
	}

}
