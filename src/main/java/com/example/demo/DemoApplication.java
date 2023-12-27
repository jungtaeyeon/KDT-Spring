package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@ServletComponentScan  // 서블릿
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(DemoApplication.class, args);
    // 등록된 빈의 목록
    //String[] beanNames = ac.getBeanDefinitionNames();
    //Arrays.sort(beanNames); // 정렬하기
    // 배열 스트림으로 변환하여 목록 출력
    //Arrays // 배열에 있는 정보를 그대로 출력할 수 없어 stream으로 변환시킴
    //.stream(beanNames) // 스트림 변환
    //.forEach(System.out::println); // 빈 목록 출력
	}
}

/*
가급적이면 코딩을 적게 한다 - 적게하지만 유지보수 좋음 - 다형성을 활용
 * DemoApplication에서 main 실행하는 것으로 서버 기동됨
 * Spring Boot - 3.16버전 - Gradle{빌드도구-배포}
 * 설정파일은
 * 1) application.properties - Properties클래스 동일함
 * 2) application.yml - json형식 - 반복코드 생략함
 * 
 * server:
  port: 8000
  servlet:
    context-path: /  -> 루트패스 설정
    encoding:
      charset: UTF-8  -> 한글 인코딩
      enabled: true
      force: true
spring:
  output:
    ansi:
      enabled: always  -> 로그 출력 옵션
  mvc:
    view:
      prefix: /WEB-INF/views/  -> 출력 설정 - ModelAndView -> ViewResolver
      suffix: .jsp
  servlet:
    multipart:   -> 첨부파일 설정
      enabled: true
 */