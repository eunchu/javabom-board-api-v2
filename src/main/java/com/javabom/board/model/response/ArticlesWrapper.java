package com.javabom.board.model.response;

import lombok.*;

//@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor

public class ArticlesWrapper<T> {

  public T getData() {
    return this.data;
  }

  private T data;

  public ArticlesWrapper(T data) {
    this.data = data;
  }
}
