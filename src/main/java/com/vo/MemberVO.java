package com.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
  private int mem_no; // private int mem_no=0; 차이점
  private String mem_id;
  private String mem_pw;
  private String mem_name;

  @Builder
  public MemberVO(int mem_no, String mem_id, String mem_pw, String mem_name) {
    super();
    this.mem_no = mem_no;
    this.mem_id = mem_id;
    this.mem_pw = mem_pw;
    this.mem_name = mem_name;
  }

}
