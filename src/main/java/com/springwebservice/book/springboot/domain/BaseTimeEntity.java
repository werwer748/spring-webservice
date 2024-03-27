package com.springwebservice.book.springboot.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * BaseTimeEntity클래스는 모든 Entity의 상위 클래스가 되어
 * Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할
 */

@Getter
@MappedSuperclass // 해당 클래스를 상속할 경우 이 클래스의 필드들을 컬럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) //이 클래스에 Auditing기능을 포함 시킨다.
public class BaseTimeEntity {

    @CreatedDate // 엔티티 생성 후 저장때 시간이 자동 저장됨.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회된 엔티티의 값이 변경될 때 시간이 자동 저장 됨.
    private LocalDateTime modifiedDate;
}
