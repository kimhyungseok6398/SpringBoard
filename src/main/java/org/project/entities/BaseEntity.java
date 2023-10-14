package org.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//추상클래스 하위클래스에 공통으로 쓸수 있는 것
// 객체생성

//@MappedSuperclass
//상위클래스의 호환될수 있는 공통 속성화
@Getter
@Setter
@MappedSuperclass
// 날짜와 시간적인 표준적인 크리에이트 데이트 , 라스트 모디파이를 쓸려면 이벤트 리스너가 필요하기에 사용
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate // 표준적인 부분임 추가될떄만 추가되고
    @Column(updatable = false)


    private LocalDateTime createdAt; //공통 생성일자
    @LastModifiedDate // 수정될떄만 수정되도록
    @Column(insertable = false)
    private LocalDateTime modifiedAt;


}
