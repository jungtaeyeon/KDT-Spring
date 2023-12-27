package com.example.demo.di2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogic {
  Logger logger = LoggerFactory.getLogger(TestLogic.class);
  TestDao testDao = null;

  public void setTestDao(TestDao testDao) {
    this.testDao = testDao;
  }

  public List<Map<String, Object>> testList() {
    System.out.println("TestLogic testList() 호출");
    List<Map<String, Object>> list = null;
    list = testDao.testList();
    return list;
  }

}
