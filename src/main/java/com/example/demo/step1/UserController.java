package com.example.demo.step1;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/user/*")
public class UserController {
  Logger logger = LoggerFactory.getLogger(UserController.class);

  // http://localhost:8000/user/login?mem_id=kiwi&mem_pw=123
  @GetMapping("login")
  // public String login(String mem_id, String mem_pw) { // @RequestParam 생략 가능
  public String login(@RequestParam String mem_id, String mem_pw) { 
    logger.info(mem_id +", "+mem_pw);
    // return "forward:/index.jsp"; // -> 앞에 forward: 또는 redirect: 를 붙이면 webapp 에 있는 index.jsp를 찾는다.
    return "redirect:/index.jsp";
  }

  @GetMapping("login2")
  public String login2(@RequestParam Map<String, Object> pMap) { 
    // http://localhost:8000/user/login2
    // http://localhost:8000/user/login2?mem_id=kiwi&mem_pw=123&mem_name=키위
    logger.info(pMap.get("mem_id") +", "+pMap.get("mem_pw")+", "+pMap.get("mem_name"));
    // return "forward:/index.jsp"; // -> 앞에 forward: 또는 redirect: 를 붙이면 webapp 에 있는 index.jsp를 찾는다.
    return "redirect:/index.jsp";
  }

  // http://localhost:8000/user/loginForm
  @GetMapping("loginForm")
  public String loginForm() {
    logger.info("loginForm");
    // ViewResolver가 해준다. -> 설정값: application.yml
    // 접두어 : /WEB-INF/views/
    // 접미어 : .jsp
    // return "user/loginForm";
    // POJO - upmu[0] - workname - @RequestMapping("/user/*") - 요청 시 이미 /user 를 알고 있다.
    // POJO - upmu[1] - 메소드 이름, 화면이름
    return "redirect:./loginForm.jsp";
  }
  // ModelAndView - WEB-INF를 찾음, forward 유효범위를 갖는다. scope: request이다.
  // 그래서 url은 그대로 인데 화면은 바뀐다.
  // 화면의 이름을 생략하면 메소드 이름이 화면 이름이 된다. - 스프링이 그렇게 주입한다.
  @GetMapping("loginForm2")
  public ModelAndView loginForm2() {
    logger.info("loginForm2");
    // ModelAndView mav = new ModelAndView();
    // mav.setViewName("loginForm2");
    // return mav;
    return new ModelAndView(); // WEB-INF/views/user/loginForm2.jsp 를 찾는다 -> 
  }

}
