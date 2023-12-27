package com.example.demo.di;

public class WoodDuck extends Duck {
	WoodDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior = new MuteQuack();
	}
	@Override
	public void display() {
	}

}
