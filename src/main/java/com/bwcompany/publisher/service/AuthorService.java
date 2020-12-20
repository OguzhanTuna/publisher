package com.bwcompany.publisher.service;

import com.bwcompany.publisher.dto.Author;
import com.bwcompany.publisher.dto.KeyAuthor;
import com.bwcompany.publisher.presentation.SimpleAuthor;
import com.bwcompany.publisher.presentation.http.request.CreateAuthorRequest;
import com.bwcompany.publisher.presentation.http.request.FindAuthorRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

public interface AuthorService {
    Author create(CreateAuthorRequest request);

    Set<SimpleAuthor> search(@NotNull @Valid @Validated(FindAuthorRequest.class) FindAuthorRequest request);

    Optional<Author> findById(KeyAuthor request);

}
