package com.bwcompany.publisher.mapper;

import com.bwcompany.publisher.domain.BookEntity;
import com.bwcompany.publisher.dto.Book;
import com.bwcompany.publisher.presentation.SimpleBook;
import com.bwcompany.publisher.presentation.http.request.CreateBookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book mapToDto(BookEntity authorEntity);

    BookEntity create(CreateBookRequest request);

    default Set<SimpleBook> from(Set<Book> books) {

        return books.stream().map(x -> ((SimpleBook) x)).collect(Collectors.toSet());
    }
}
