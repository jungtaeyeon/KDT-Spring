package com.example.demo.kakao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.vo.OAuthToken;


@Controller
@RequestMapping("/auth/*")
public class KakaoController2 {
  Logger logger = LoggerFactory.getLogger(KakaoController2.class);

  // @ResponseBody 를 붙이면 Data를 리턴해주는 컨트롤러 메소드가 된다. => RestController와 같은 역할이라고 생각해도 된다.
  @GetMapping("kakao/callback")
  public @ResponseBody String kakaoCallback(String code){
    logger.info("kakaoCallback 호출");
    logger.info(code);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("grant_type", "authorization_code");
    params.add("client_id", "dab7a2fa14e99d854cd5a5757db20c79");
    params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
    params.add("code", code);
    // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
    HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(params, headers);
    RestTemplate rt = new RestTemplate();
    ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, tokenRequest, String.class);
    Gson g = new Gson();
    OAuthToken oat = g.fromJson(response.getBody(), OAuthToken.class); // 파라미터 두번째 자리 -> 어디에 담아줄까?
    
    // 사용자 정보 가져오기 
    HttpHeaders headers2 = new HttpHeaders();
    headers2.add("Authorization", "Bearer "+oat.getAccess_token());
    headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
    
    // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
    HttpEntity<MultiValueMap<String, String>> profileRequest = new HttpEntity<>(headers2);
    RestTemplate rt2 = new RestTemplate();
    ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, profileRequest, String.class);

    return response2.getBody(); // 사용자 정보 가져오기
  }
  
}
