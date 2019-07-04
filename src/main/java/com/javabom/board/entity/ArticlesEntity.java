package com.javabom.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor // 모든 필드의 생성자 생성
@NoArgsConstructor // default 생성자 생성
@Builder

public class ArticlesEntity {

  @Id // PK
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String title;

  @Column
  private String contents;

}

//@Builder
//
//public @Data class ArticlesEntity {
//
//  @Id // PK
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long id;
//
//  @Column @NonNull // 자동 null 체크
//  private String title;
//
//  @Column @NonNull
//  private String contents;
//
//}