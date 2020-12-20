package com.bwcompany.publisher.presentation.http.request;

import com.bwcompany.publisher.dto.Book;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;

@JsonSerialize(as = Book.class)
public interface CreateBookRequest {

    @NotEmpty
    String getName();
}
