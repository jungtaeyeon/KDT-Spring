package com.example.demo.restful;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vo.MemberVO;

@RestController
@RequestMapping("/http/*")
public class RestfulController {
  Logger logger = LoggerFactory.getLogger(RestfulController.class);

  // 테스트 방법 -> http://localhost:8000/http/get?mem_id=kiwi&mem_name=키위
  @GetMapping("get")
  public String getTest(MemberVO mVO){
    return "get요청" + ", " + mVO.getMem_id() + ", " + mVO.getMem_name();
  }
  // URL 요청이름 == 메소드이름 == 화면이름
  // : 왜 맞춰야 하나?? - 디버깅 - 추적 - 같은이름:혼동:라인번호, 시간
  // demo_member테이블 이름 == VO이름 == 제네릭 맵 사용시 키값
  // 테스트 방법 -> http://localhost:8000/http/lombokTest?mem_no=5&mem_id=apple
  @GetMapping("lombokTest")
  public String lombokTest(MemberVO mVO){
    MemberVO mVO2 = MemberVO.builder().mem_id(mVO.getMem_id()).mem_no(mVO.getMem_no()).build();
    return "lombok테스트 요청: " +  mVO2.getMem_id() + ", " + mVO2.getMem_name()+"||"+mVO2.getMem_no();
  }

  @PostMapping("post")
  public String postTest(MemberVO mVO){
    return "post요청" + ", " + mVO.getMem_id() + ", " + mVO.getMem_name();
  }

  @PostMapping("post2")
  public String post2Test(@RequestBody MemberVO mVO){ // @RequestBody 의 기본은 json이다. -> 그래서 json으로 받아와야 한다!
    return "post요청" + " " + mVO.getMem_id() + ", " + mVO.getMem_name();
  }

  @PostMapping("post3")
  public String post3Test(@RequestParam Map<String, Object> pMap){ // @RequestBody 의 기본은 json이다. -> 그래서 json으로 받아와야 한다!
    return "post요청" + " " + pMap.get("mem_id") + ", " + pMap.get("mem_name");
  }

  // 테스트 방법 -> http://localhost:8000/http/update/3
 @PutMapping("update/{id}")
  public MemberVO update(@PathVariable int id){ // 리턴타입에 오브젝트도 가능한지 확인!
    MemberVO mVO = new MemberVO();
    mVO.setMem_id("nice");
    logger.info(String.valueOf(id));
    return mVO;
  }
 // 테스트 방법 -> http://localhost:8000/http/delete/5
 @DeleteMapping("delete/{no}")
 // delete from demo_member where no=7
 //@PathVariable 값은 상세조회시 나 삭제 시 pk값으로 사용된다.
  public String delete(@PathVariable int no){
    logger.info(String.valueOf(no)); // 5
    return String.valueOf(no);
  }

}

/*
 * 1. GET요청(select시 사용)
 * : 주소에 데이터를 담아 보낸다
 * : 데이터 형태는 key=value 이다.
 * 
 * 2. POST, PUT, DELETE 요청
 * : Body에 담아서 보낸다
 * : 데이터 형태는 json으로 통일
 * : form태그 요청은 get요청과 post요청만 가능함. -> 수정 삭제도 get, post 사용해도 무방하다.
 * : put, delete는 자바스크립트로 요청함 -> 테스트 번거로움...
 * 
 * 화면쪽에 템플릿엔진, 리액트 사용한다면
 * restful 요청할 때 자바스크립트로 요청해야함 -> ajax, fetch, axios -> 비동기 처리 지원하는 API
 * 자바스크립트는 기본적으로 동기가 디폴트. 
 */