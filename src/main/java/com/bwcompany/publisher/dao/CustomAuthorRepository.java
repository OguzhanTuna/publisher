package com.bwcompany.publisher.dao;

import com.bwcompany.publisher.domain.AuthorEntity;
import com.bwcompany.publisher.presentation.http.request.FindAuthorRequest;

import java.util.stream.Stream;

public interface CustomAuthorRepository {

    Stream<AuthorEntity> search(FindAuthorRequest request);
}
