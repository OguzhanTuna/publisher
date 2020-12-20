package com.bwcompany.publisher.service;


import com.bwcompany.publisher.dto.KeyPublisher;
import com.bwcompany.publisher.dto.Publisher;
import com.bwcompany.publisher.presentation.SimplePublisher;
import com.bwcompany.publisher.presentation.http.request.CreatePublisherRequest;
import com.bwcompany.publisher.presentation.http.request.FindPublisherRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

public interface PublisherService {


    SimplePublisher create(@NotNull @Valid @Validated(CreatePublisherRequest.class) CreatePublisherRequest request);

    Optional<Publisher> findById(@NotNull @Valid KeyPublisher keyPublisher);

    Set<SimplePublisher> findAll(@NotNull @Valid @Validated(FindPublisherRequest.class) FindPublisherRequest request);


}
