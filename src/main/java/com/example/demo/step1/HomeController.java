package com.example.demo.step1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// 스프링에서는 서블릿과 다르게 메소드 마다 url매핑이 가능하다.
import org.springframework.web.bind.annotation.GetMapping;


@RestController // @Controller 어노테이션과는 다르게 응답이 page가 아니고 text/plain이다. 또는 페이지 출려깅 아닌 모든 경우에 사용이 가능하다.
// 또는 페이지 출력이 아닌 모든 경우에 사용이 가능하다.
// @Controller를 사용하면 메소드 이름이 페이지 이름이 된다.
@RequestMapping("/step1/*")
public class HomeController {
  Logger logger = LoggerFactory.getLogger(HomeController.class);

  // 스프링 에서는 req.getParameter를 쓰지 않고도 파라미터 자리에 넣어주는 것 만으로 자동으로 담아줌 -> @RequestParam -> 생략가능
  // url - http://localhost:8000/step1/home
  // 스프링에서는 클래스와 빈은 같은말로 이해하자.
  // 어떻게 이런일이 가능할까?? - 빈관리 - spring-context.jar -> ApplicationContext라는 빈 컨테이너가 살고있어서 빈을 관리해줌
  // 스프링에서 의존성 주입을 담당하니까 가능한 것 이다.
  // 환경설정 - spring-core.jar - 환경설정 - myBatis, Hikaricp 외부 라이브러리 - IoC
  // 라이브러리에는 없는 제어권을 스프링이 가진다.
  // 스프링을 사용하면 객체에 대한 라이프사이클 관리를 빼앗긴다.
  // 개발자 객체에 대한 관리 책임(관심사)이 아니다. -> 제어역전 IoC
  @GetMapping("home") // 메소드가 호출되는 매핑 이름 이다.
  public String home(@RequestParam String param, String param1) { // url - http://localhost:8000/step1/home?param=152 -> param 변수에 152이 담긴다.
    logger.info("home");
    logger.info(param);
    logger.info(param1);
      return "반환되는 문자열";
      // return "home" // @Controller 를 사용하면 -> WEB-INF/views/home.jsp 로 이동된다.
  }

  @GetMapping("jsonTest") // 메소드가 호출되는 매핑 이름 이다.
  public String jsonTest() { // url - http://localhost:8000/step1/jsonTest -> param 변수에 152이 담긴다.
    logger.info("jsonTest");
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> map = new HashMap<>();
    map.put("deptno", 10);
    map.put("dname", "총무부");
    map.put("loc", "인천");
    list.add(map);
    logger.info(list.toString());
    Gson g = new Gson();
    String temp = g.toJson(list);
    logger.info(temp);
    return temp;
  }
}
/*
컨트롤계층 갖는 특장 - 역할 - 가진 것
상속을 받지는 않았지만 req, res는 여전히(순수성-다른언어와 조합, 이종간에 조립) 사용이 가능하다.
입력(@RequestParam) -> 처리 -> 출력
 * 컨트롤 계층이면 
 * 1) 응답페이지 처리에 대한 책임(관심사)
 * 2) 필요할 떄 요청 객체와 응답 객체를 사용할 수 있다. - 없어진게 아니다.
 * public String home(String param, HttpServletRequest req)
 * 메소드의 파라미터 갯수에 제약이 없다.
 * 실제 처리는 하지 않는다 - 처리는 미룬다 - XXXLogic클래스가 담당함
 */