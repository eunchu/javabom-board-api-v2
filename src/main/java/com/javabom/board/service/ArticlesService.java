package com.javabom.board.service;

import com.javabom.board.model.articles.Articles;
import com.javabom.board.model.response.ArticlesWrapper;

import java.util.List;

public interface ArticlesService {

  /*
  * GET | 전체 목록
  */
  List<Articles> findAll();

  /*
  * POST | 목록 생성
  */
  ArticlesWrapper save(Articles articles);

}
