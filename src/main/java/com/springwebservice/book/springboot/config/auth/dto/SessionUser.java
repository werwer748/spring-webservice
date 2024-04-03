package com.springwebservice.book.springboot.config.auth.dto;

import com.springwebservice.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
/** Serializable? 클래스를 직렬화 한다.
 * 직렬화(serialize)란 자바 언어에서 사용되는 Object 또는 Data를
 * 다른 컴퓨터의 자바 시스템에서도 사용 할수 있도록
 * 바이트 스트림(stream of bytes) 형태로 연속전인(serial) 데이터로 변환하는 포맷 변환 기술을 일컫는다
 *
 * 역직렬화는(Deserialize)는 바이트로 변환된 데이터를
 * 원래대로 자바 시스템의 Object 또는 Data로 변환하는 기술이다.
 */
public class SessionUser implements Serializable {

    // 인증된 사용자 정보만 필요하기 때문에 세가지만 필드로 선언.
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
