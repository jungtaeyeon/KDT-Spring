package com.example.demo.di2;
import java.util.*;

import org.springframework.context.annotation.Bean;

import java.lang.reflect.*;
import java.lang.annotation.Annotation;

public class MyContext {
  Map<String, Object> map = new HashMap<>();
  public MyContext(){
    map.put("testController", new TestController());
    map.put("testLogic", new TestLogic());
    map.put("testDao", new TestDao());
  }

  @SuppressWarnings("deprecation") // 이걸 쓰면 듀플리케이트(중간선) 없어진다. -> 몰라도 된다.
  public MyContext(Class<?> clazz) { // 파라미터 자리 - MyConfig 가 들어온다. - @Configuration - 스캔되고 있다 - @Bean 등록
    try {
      Object MyConfig = clazz.newInstance();
      for(Method m: clazz.getDeclaredMethods()){ // 메소드 정보를 가져올 수 있도록..
        for(Annotation ann: m.getDeclaredAnnotations()){
          if(ann.annotationType() == Bean.class){ // 객체를 생성
            // 메소드 이름(testController, testLogic, testDao)을 키값으로 하여 값을 생성함
            map.put(m.getName(), m.invoke(MyConfig, null));
          }
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
  Object getBean(String id) { // 메소드 이름으로 객체 찾기
    return map.get(id);
  }
  // 타입 비교 instanceof
  // 타입으로 객체 찾기
  Object getBean(Class<?> clazz){
    for(Object obj: map.values()) {
      if (clazz.isInstance(obj)) { // isInstance()) 가 instanceof와 동일한 역할
        return obj;
      }
    }
    return null;
  }
}
