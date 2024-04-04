package com.springwebservice.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // JPA Auditing 활성화 => @WebMvcTest는 일반적인 @Configuration은 스캔하지 않는다.
public class JpaConfig {
}
