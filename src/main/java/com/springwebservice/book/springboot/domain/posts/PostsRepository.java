package com.springwebservice.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동 생성된다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    /**
     * SpringDataJpa에서 제공하지 않는 메소드는 @Query로 작성해도 된다.
     */
    @Query("select p from Posts p order by p.id desc ")
    List<Posts> findAllDesc();
}
