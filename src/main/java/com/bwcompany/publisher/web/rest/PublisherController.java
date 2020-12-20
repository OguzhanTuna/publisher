package com.bwcompany.publisher.web.rest;

import com.bwcompany.publisher.dto.KeyPublisher;
import com.bwcompany.publisher.dto.Publisher;
import com.bwcompany.publisher.presentation.SimplePublisher;
import com.bwcompany.publisher.presentation.http.request.CreatePublisherRequest;
import com.bwcompany.publisher.presentation.http.request.FindPublisherRequest;
import com.bwcompany.publisher.service.PublisherService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public SimplePublisher create(@RequestBody CreatePublisherRequest request) {

        return publisherService.create(request);
    }

    @PostMapping("/find-all")
    public ResponseEntity<Set<SimplePublisher>> findAll(@RequestBody FindPublisherRequest request) {

        return Optional.of(publisherService.findAll(request))
                .filter(CollectionUtils::isNotEmpty)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

    @GetMapping("/detail")
    public ResponseEntity<Publisher> detail(@ModelAttribute KeyPublisher keyPublisher) {

        return publisherService.findById(keyPublisher)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

}
