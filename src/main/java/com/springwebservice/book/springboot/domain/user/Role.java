package com.springwebservice.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    // 스프링 시큐리티에서는 권한 코드에 항상 ROLE_ 가 앞에 있어야 한다.
    GUEST("GUEST", "Guest"),
    USER("USER", "Common User");

    private final String key;
    private final String title;
}
