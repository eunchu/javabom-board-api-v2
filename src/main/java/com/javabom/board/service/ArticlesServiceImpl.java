package com.javabom.board.service;

import com.javabom.board.entity.ArticlesEntity;
import com.javabom.board.model.articles.Articles;
import com.javabom.board.model.articles.Attributes;
import com.javabom.board.model.articles.Links;
import com.javabom.board.model.response.ArticlesWrapper;
import com.javabom.board.repository.ArticlesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor

//@SuppressWarnings("all")

public class ArticlesServiceImpl implements ArticlesService {

  @Autowired
  private ArticlesRepository articlesRepository;

  @Override
  public List<Articles> findAll() {
//
    List<ArticlesEntity> articlesEntities = articlesRepository.findAll();
    List<Articles> articlesList = new ArrayList<Articles>();
//
//    // 초기화식, 조건식, 업데이트식   |   변수타입 변수이름 : 배열이름
    for (int i = 0; i < articlesEntities.size(); i++) {
      Articles articles = new Articles();
      Attributes attributes = new Attributes();
      Links links = new Links();

      attributes.setTitle(articlesEntities.get(i).getTitle());
      attributes.setContent(articlesEntities.get(i).getContents());
      articles.setId(articlesEntities.get(i).getId());
      articles.setType("articles");
      links.setSelf("https://board-api/api/v1/articles/" + articlesEntities.get(i).getId());
      articles.setAttributes(attributes);
      articles.setLinks(links);

      articlesList.add(articles);
    }

    ArticlesWrapper<List<Articles>> articlesWrapper = new ArticlesWrapper<>(articlesList);
//    ArticlesWrapper articlesWrapper = new ArticlesWrapper(articlesList);

    return articlesList;
  }

  @Override
  public ArticlesWrapper save(Articles articles) {

    ArticlesEntity articlesEntity = new ArticlesEntity();

    ArticlesEntity setArticleEntity = ArticlesEntity.builder()
            .title("article_" + articlesEntity.getId())
            .contents("article content_" + articlesEntity.getId())
            .build();

    Attributes attributes = Attributes.builder()
            .title(setArticleEntity.getTitle())
            .content(setArticleEntity.getContents())
//            .title("article_" + articlesEntity.getId())
//            .content("article content_" + articlesEntity.getId())
            .build();

    Links links = Links.builder()
            .self("https://board-api/api/v1/articles/" + articlesEntity.getId())
            .build();

    articles = Articles.builder()
            .id(articlesEntity.getId())
            .type("articles")
            .attributes(attributes)
            .links(links)
            .build();

    ArticlesWrapper<Articles> articlesWrapper= new ArticlesWrapper<>();
    articlesWrapper.setData(articles);

    System.out.print(articles);

    ArticlesEntity requestEntity = articlesRepository.save(articlesEntity);

    return articlesWrapper;
  }
}
