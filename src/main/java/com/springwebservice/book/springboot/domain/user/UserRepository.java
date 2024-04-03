package com.springwebservice.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // email 필드값이 있기때문에 자동 매칭
    Optional<User> findByEmail(String email);
}
