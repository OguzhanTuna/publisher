package com.bwcompany.publisher.mapper;

import com.bwcompany.publisher.domain.AuthorEntity;
import com.bwcompany.publisher.dto.Author;
import com.bwcompany.publisher.presentation.http.request.CreateAuthorRequest;
import com.bwcompany.publisher.presentation.http.request.FindAuthorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author mapToDto(AuthorEntity authorEntity);

    AuthorEntity search(FindAuthorRequest request);

    AuthorEntity create(CreateAuthorRequest request);
}
