package com.springwebservice.book.springboot.config.auth;

import com.springwebservice.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Spring Security 설정을 활성화시켜 준다.
@RequiredArgsConstructor
public class SecurityConfig {

    private final  CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf((csrfConfig) -> csrfConfig.disable())
                .headers((headerConfig) ->
                        // h2-console 화면 사용을 위해 해당옵션 disable
                        headerConfig.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable())
                )
                .authorizeHttpRequests((authorizeRequests) ->
                        // URL 별 권한관리 설정 옵션
                        authorizeRequests
                                // 전체 열람권한
                                .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                                // USER 권한을 가진 사람만 /api/v1/** api 호출 가능
                                .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
                                // anyRequest: 설정값들 외 URL, authenticated: 인증된 사용자에게만 허용
//                                .anyRequest().authenticated()
                )
//                .exceptionHandling((exceptionConfig) ->
//                        )
                .logout((logoutConfig) ->
                        // 로그아웃 기능 설정의 진입점
                        logoutConfig
                                // 로그아웃 성공시 / 주소로 이동
                                .logoutSuccessUrl("/")
                )
                .oauth2Login((oauthLogin) ->
                        // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                        oauthLogin
                        // userInfoEndpoint: OAuth2 로그인 성공 이후 사용자 정보를 가저올 때의 설정들을 담당
                        .userInfoEndpoint((userInfo) ->
                                /**
                                 * userService: 로그인 성공 후 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
                                 * 리소스 서버(소셜서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
                                 */
                                userInfo.userService(customOAuth2UserService)
                        )
                );

        return http.build();
    }
}
