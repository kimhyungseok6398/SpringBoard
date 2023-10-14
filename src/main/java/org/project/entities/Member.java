package org.project.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*; // Entity -> * 로 변경
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//공통속성화  날짜나 등록일자 수정일자를 매번
//쓰기가 불편하므로 상속을 통해서 공통속성화 작업
@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(indexes = {
        @Index(name="idx_member_userNm",columnList = "userNm"),
        @Index(name="idx_member_email",columnList = "email")
        
})
public class Member extends BaseEntity {

    @Id  @GeneratedValue // @Id 기본키 , @GeneratedValue 자동증감번호
    private Long userNo; // 회원번호 , 조인 , 외래키 회원번호로 주로 사용

    @Column(length=40, nullable = false, unique = true) // 유니크가 있으면 따로 키 입력x
    private String userId; // 회원아이디

    @Column(length=65, nullable = false)
    private String userPw; // 회원비밀번호

    @Column(length=40, nullable = false)
    private String userNm; // 회원명
    // 비번을 분실할 경우 이메일을 초기화 URL 하여 사용하거나
    // 이메일로 구성할것
    @Column(length=100, nullable = false)
    private String email; // 이메일

    @Column(length=11)
    private String mobile; // 휴대전화번호

    @Lob // Json 형태로 받음
    private String termsAgree; // 약관동의내역
    //약관 준비중
}
