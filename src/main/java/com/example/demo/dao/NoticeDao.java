package com.example.demo.dao;

import java.util.List;
import java.util.Map;  

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// XXXDao 클래스는 MVC패턴에 영향을 주는 클래스는 아니다. - 디자인 패턴? 으로 이해하자.
import org.springframework.web.bind.annotation.RequestParam;

@Service // 
// @Repository // @Service 를 사용해도 기능에 문제는 없다!
// 모델계층 (비지니스로직 + 퍼시스턴스계층)
public class NoticeDao { // 데이터 영속성을 처리하는 계층 - 퍼시스턴스 계층이다.
  Logger logger = LoggerFactory.getLogger(NoticeDao.class);
  @Autowired
  SqlSessionTemplate sqlSessionTemplate = null; // -> SqlSession


  public List<Map<String, Object>> noticeList(@RequestParam Map<String, Object> pMap) {
    logger.info("NoticeDao -> noticeList()");
    // List<Map<String, Object>> list = sqlSessionTemplate.selectList("noticeList"); // 전체조회
    List<Map<String, Object>> list = sqlSessionTemplate.selectList("noticeList", pMap); // gubun: n_title, keyword: 휴관
    logger.info(list.toString());
    return list;
  }

  public int noticeInsert(Map<String, Object> pMap) {
    logger.info("NoticeDao -> noticeInsert()");
    int result = 0;
    result = sqlSessionTemplate.insert("noticeInsert", pMap);
    logger.info(Integer.toString(result));
    return result;
  }


  public int noticeUpdate(Map<String, Object> pMap) {
    logger.info("NoticeDao -> noticeUpdate()");
    int result = 0;
    result = sqlSessionTemplate.update("noticeUpdate", pMap);
    logger.info(Integer.toString(result));
    return result;
  }


  public int noticeDelete(Map<String, Object> pMap) {
    int result = 0;
    result = sqlSessionTemplate.delete("noticeDelete", pMap);
    logger.info(Integer.toString(result));
    return result;
  }
}
