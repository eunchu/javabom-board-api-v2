package com.javabom.board.controller;

import com.javabom.board.model.articles.Articles;
import com.javabom.board.model.response.ArticlesWrapper;
import com.javabom.board.service.ArticlesService;
import javafx.print.Printer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor

//@SuppressWarnings("all") // 경고 무시

public class ArticlesController {

  private ArticlesService articlesService;

  @GetMapping("/articles")
  public ResponseEntity<ArticlesWrapper> allArticles() {
    List<Articles> articlesList = articlesService.findAll();
    ArticlesWrapper<List<Articles>> articlesWrapper = new ArticlesWrapper<>(articlesList);

    if (articlesList.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<ArticlesWrapper>(articlesWrapper, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ArticlesWrapper> create(@RequestBody ArticlesWrapper<Articles> articleContainer) {
    ArticlesWrapper articlesWrapper = articlesService.save(articleContainer.getData());

    return new ResponseEntity<ArticlesWrapper>(articlesWrapper, HttpStatus.CREATED);
  }

}

//  @PostMapping(value = "/api/v1/articles")
//  public ResponseEntity<ArticleDTO> save(@RequestBody ArticleDTO<ArticleObject> articleDTO) {
//
//    ArticleDTO entity = articleService.create(articleDTO.getData());
//
//    return ResponseEntity.status(201).body(entity);
//  }


// 1. @AllArgsConstructor
// 2. public ArticlesController(ArticlesService articlesService) {
//    this.articlesService = articlesService;
//  }
// 3. @Autowired