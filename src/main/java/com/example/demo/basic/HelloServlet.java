package com.example.demo.basic;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
// tomcat10.X 버전에서는 4.0서블릿 사용이 불가능 - 6.0버전 -> jakarta패키지
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/runTime")
public class HelloServlet extends HttpServlet{
  Logger logger = LoggerFactory.getLogger(HelloServlet.class);

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    logger.info("service");
    // 1. 전처리 작업
    long startTime = System.currentTimeMillis();
    // 2. 작업처리
    for(double d=0; d<9999999.0;d++) {
      // 지연 상태를 강제로 만들어 본다.
    }
    res.setContentType("text/html;charset=utf-8");
    PrintWriter out = res.getWriter();
    String content = "컨텐츠";
    out.print("<html>");
    out.print("<head><title>서블릿테스트</title></head>");
    out.print("<body>내용..."+content+"</body>");
    out.print("</html>");
    // 3. 후처리 작업 - 수행시간 계산
    // 종료시간 - 시작시간 = 소요시간
    System.out.print(" [ " + req.getRequestURI() + " ] ");
    System.out.println("time = " +(System.currentTimeMillis() - startTime)+"ms");;
  }
}
