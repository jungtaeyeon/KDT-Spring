package com.example.demo.logic;

import java.util.List;
import java.util.Map;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.NoticeDao;

@Service // 모델 계층
public class NoticeLogic {
  Logger logger = LoggerFactory.getLogger(NoticeLogic.class);
  @Autowired
  NoticeDao noticeDao = null;

  public List<Map<String, Object>> noticeList(@RequestParam Map<String, Object> pMap) {
    logger.info("NoticeLogic -> noticeList()");
    List<Map<String, Object>> list = null;
    //////// @Service, @Autowired
    // noticeDao변수는 NoticeLogic에서 선언만 되었다. new가 없다 - ApplicationContext에서 생성해줌
    // 왜냐면 NoticeLogic앞에 @Service가 붙어있어서..
    // 이렇게 주입받은 객체의 인스턴스변수로 NoticeDao에 선언된 noticeList메소드를 호출하고 있다.
    // NoticeLogic과 NoticeDao의 연관관계에 대해 고민해볼 것
    list = noticeDao.noticeList(pMap); // 조건검색
    // list = noticeDao.noticeList(); // 전체조회
    return list;
  }

  public int noticeInsert(Map<String, Object> pMap) {
    logger.info("NoticeLogic -> noticeInsert()");
    int result = 0;
    result = noticeDao.noticeInsert(pMap);
    return result;
  }

  public int noticeUpdate(Map<String, Object> pMap) {
    logger.info("NoticeLogic -> noticeUpdate()");
    int result = 0;
    result = noticeDao.noticeUpdate(pMap);
    return result;
  }

  public int noticeDelete(Map<String, Object> pMap) {
    logger.info("NoticeLogic -> noticeDelete()");
    int result = 0;
    result = noticeDao.noticeDelete(pMap);
    return result;
  }
  
}
