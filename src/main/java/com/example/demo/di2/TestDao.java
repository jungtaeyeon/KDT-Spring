package com.example.demo.di2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDao {
  Logger logger = LoggerFactory.getLogger(TestDao.class);

  public List<Map<String, Object>> testList() {
    System.out.println("TestsetDao testList() 호출");
    return new ArrayList<>();
  }
}
