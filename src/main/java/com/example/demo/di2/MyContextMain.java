package com.example.demo.di2;
// 실습 제목 - ApplicationContext 무작정 따라해보기
// 소개 목적 - myBatis같은 외부 라이브러리를 사용할 때 사용하라 - 공통코드 작성하기 - 공통팀에 근무
// 예) DatabaseConfiguration, CorsConfiguration.java
public class MyContextMain {
  public static void main(String[] args) {
    MyContext mc = new MyContext(MyConfig.class);
    System.out.println(mc.map);

    TestController testController2 = new TestController(); // 하드코딩 - 라이프사이클 책임이 너 이다.
    System.out.println(testController2);
    // 위 코드는 우리가 관리해야함 - 이렇게 코딩XXXX
    // 아래처럼 Bean에서 가져오는 것은 스프링에서 관리해주는 것
    TestController testController = (TestController)mc.getBean("testController"); // - IoC, 관리받음 
    System.out.println(testController);
    // 위와 같은 주소번지를 출력한다?? -> 원본을 사용하는 싱글톤패턴!
    // 멀티스레드를 운영하여 한정된 자원을 여러 사용자가 누릴 수 있다. 
    TestController testController3 = (TestController)mc.getBean(TestController.class); // - IoC, 관리받음
    System.out.println(testController3);

    TestDao testDao = (TestDao)mc.getBean(TestDao.class);
    TestLogic testLogic = (TestLogic)mc.getBean("testLogic"); // - IoC, 관리받음
    testLogic.setTestDao(testDao);
    testController.setTestLogic(testLogic); // 관계있는 클래스에 객체 주입 코드 -> 이부분을 생략 가능하게 만들어주는 어노테이션 -> @AutoWired사용
    String tl = testController.testList();
    System.out.println(tl);

    
  }
}
