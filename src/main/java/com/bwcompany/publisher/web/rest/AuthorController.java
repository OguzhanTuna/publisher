package com.bwcompany.publisher.web.rest;

import com.bwcompany.publisher.dto.Author;
import com.bwcompany.publisher.dto.KeyAuthor;
import com.bwcompany.publisher.presentation.SimpleAuthor;
import com.bwcompany.publisher.presentation.http.request.CreateAuthorRequest;
import com.bwcompany.publisher.presentation.http.request.FindAuthorRequest;
import com.bwcompany.publisher.service.AuthorService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(name = "/create")
    public Author create(CreateAuthorRequest request) {

        return authorService.create(request);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Set<SimpleAuthor>> search(@RequestBody FindAuthorRequest request) {

        return Optional.of(authorService.search(request))
                .filter(CollectionUtils::isNotEmpty)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

    @GetMapping(value = "/detail")
    public ResponseEntity<Author> detail(@ModelAttribute KeyAuthor authorKey) {

        return authorService.findById(authorKey)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

}
