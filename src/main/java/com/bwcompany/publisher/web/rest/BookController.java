package com.bwcompany.publisher.web.rest;

import com.bwcompany.publisher.dto.Book;
import com.bwcompany.publisher.dto.KeyBook;
import com.bwcompany.publisher.presentation.SimpleBook;
import com.bwcompany.publisher.presentation.http.request.CreateBookRequest;
import com.bwcompany.publisher.presentation.http.request.FindBookRequest;
import com.bwcompany.publisher.service.BookService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public SimpleBook create(@RequestBody CreateBookRequest request) {

        return bookService.create(request);
    }

    @GetMapping("/search")
    public ResponseEntity<Set<SimpleBook>> search(@RequestBody FindBookRequest request) {

        return Optional.of(bookService.search(request))
                .filter(CollectionUtils::isNotEmpty)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

    @GetMapping(value = "/detail")
    public ResponseEntity<Book> detail(@ModelAttribute KeyBook keyBook) {

        return bookService.findById(keyBook)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

}