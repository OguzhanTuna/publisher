package com.bwcompany.publisher.presentation;

import com.bwcompany.publisher.dto.Book;
import com.bwcompany.publisher.dto.KeyBook;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = Book.class)
public interface SimpleBook extends KeyBook {

    String getName();
}
