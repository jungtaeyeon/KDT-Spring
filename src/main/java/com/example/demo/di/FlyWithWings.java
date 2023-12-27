package com.example.demo.di;
//동일 메소드를 호출해도 구현체 클래스에 따라
//어느 클래스엔 날고 어느 클래스엔 날지 못한다 - 다형성(폴리모피즘)
//전제조건 = 인스턴스화를 함에 있어 선업부의 타입과 생성부의 타입이 무조건 다를 때 다형성을 떠올리자
//List list = new Arraylist();
//list = new Vector();
//list = new LinkedList();
// 이 클래스이름 안에 어디에서도 오리의 느낌이 없다 - 비행기도 사용하고 싶어요., 드론
// 결합도 낮은 코드를 작성하기 위해서 나는 인터페이스를 먼저 설계하였다.
// 유연해야 한다. -> 왜냐면 기능이 자꾸 바뀌니까, 다른 요구사항이 자꾸 생기니까 -> 확장성
public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("나는 날 수 있어!");
	}

}
