package com.bwcompany.publisher.service;


import com.bwcompany.publisher.dto.Book;
import com.bwcompany.publisher.dto.KeyBook;
import com.bwcompany.publisher.presentation.SimpleBook;
import com.bwcompany.publisher.presentation.http.request.CreateBookRequest;
import com.bwcompany.publisher.presentation.http.request.FindBookRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

public interface BookService {

    Set<SimpleBook> search(@NotNull @Valid @Validated(FindBookRequest.class) FindBookRequest request);

    SimpleBook create(CreateBookRequest request);

    Optional<Book> findById(KeyBook keyBook);
}
