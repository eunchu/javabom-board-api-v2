package com.javabom.board.model.articles;

//import lombok.*;

//@Getter
//@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Builder

public class Articles {

  private Long id;
  private String type;
  private Attributes attributes;
  private Links links;

  // @NoArgsConstructor 사용시 삭제
  public Articles() {}

  // @Getter 사용시 삭제
  public Long getId() {
    return this.id;
  }

  public String getType() {
    return this.type;
  }

  public Attributes getAttributes() {
    return this.attributes;
  }

  public Links getLinks() {
    return this.links;
  }

  // @Setter 사용시 삭제
  public void setId(Long id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }




}
