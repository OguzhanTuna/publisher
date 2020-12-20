package com.bwcompany.publisher.service.impl;

import com.bwcompany.publisher.dao.AuthorRepository;
import com.bwcompany.publisher.domain.AuthorEntity;
import com.bwcompany.publisher.dto.Author;
import com.bwcompany.publisher.dto.KeyAuthor;
import com.bwcompany.publisher.mapper.AuthorMapper;
import com.bwcompany.publisher.presentation.SimpleAuthor;
import com.bwcompany.publisher.presentation.http.request.CreateAuthorRequest;
import com.bwcompany.publisher.presentation.http.request.FindAuthorRequest;
import com.bwcompany.publisher.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author create(CreateAuthorRequest request) {
        AuthorEntity authorEntity = AuthorMapper.INSTANCE.create(request);

        authorEntity = authorRepository.save(authorEntity);

        return AuthorMapper.INSTANCE.mapToDto(authorEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<SimpleAuthor> search(@NotNull @Valid @Validated(FindAuthorRequest.class) FindAuthorRequest request) {

        return authorRepository.search(request)
                .map(AuthorMapper.INSTANCE::mapToDto)
                .collect(Collectors.toSet());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findById(KeyAuthor request) {

        return authorRepository.findById(request.getId())
                .map(AuthorMapper.INSTANCE::mapToDto);

    }
}
