package com.bwcompany.publisher.service.impl;

import com.bwcompany.publisher.dao.BookRepository;
import com.bwcompany.publisher.domain.BookEntity;
import com.bwcompany.publisher.dto.Book;
import com.bwcompany.publisher.dto.KeyBook;
import com.bwcompany.publisher.mapper.BookMapper;
import com.bwcompany.publisher.presentation.SimpleBook;
import com.bwcompany.publisher.presentation.http.request.CreateBookRequest;
import com.bwcompany.publisher.presentation.http.request.FindBookRequest;
import com.bwcompany.publisher.service.BookService;
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
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public SimpleBook create(@NotNull CreateBookRequest request) {
        BookEntity bookEntity = BookMapper.INSTANCE.create(request);

        bookEntity = bookRepository.save(bookEntity);

        return BookMapper.INSTANCE.mapToDto(bookEntity);
    }

    @Override
    public Optional<Book> findById(@NotNull KeyBook keyBook) {
        return bookRepository.findById(keyBook.getId())
                .map(BookMapper.INSTANCE::mapToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<SimpleBook> search(@NotNull @Valid @Validated(FindBookRequest.class) FindBookRequest request) {

        return bookRepository.findAll(request)
                .stream()
                .map(BookMapper.INSTANCE::mapToDto)
                .map(book -> ((SimpleBook) book))
                .collect(Collectors.toSet());
    }
}
