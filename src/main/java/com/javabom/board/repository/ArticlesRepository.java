package com.javabom.board.repository;

import com.javabom.board.entity.ArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<ArticlesEntity, Long> {
  // JPA 에서는 Repository 인터페이스 생성 후, <Entity, 기본키타입>
  // CRUD 자동 생성
}
