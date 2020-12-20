package com.bwcompany.publisher.service.impl;

import com.bwcompany.publisher.dao.PublisherRepository;
import com.bwcompany.publisher.domain.PublisherEntity;
import com.bwcompany.publisher.dto.KeyPublisher;
import com.bwcompany.publisher.dto.Publisher;
import com.bwcompany.publisher.mapper.PublisherMapper;
import com.bwcompany.publisher.presentation.SimplePublisher;
import com.bwcompany.publisher.presentation.http.request.CreatePublisherRequest;
import com.bwcompany.publisher.presentation.http.request.FindPublisherRequest;
import com.bwcompany.publisher.service.PublisherService;
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
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    @Transactional
    public SimplePublisher create(@NotNull @Valid @Validated(CreatePublisherRequest.class) CreatePublisherRequest request) {
        PublisherEntity publisherEntity = PublisherMapper.INSTANCE.create(request);

        publisherEntity = publisherRepository.save(publisherEntity);

        return PublisherMapper.INSTANCE.mapToDto(publisherEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Publisher> findById(@NotNull @Valid KeyPublisher keyPublisher) {

        return publisherRepository.findById(keyPublisher.getId())
                .map(PublisherMapper.INSTANCE::mapToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<SimplePublisher> findAll(@NotNull @Valid @Validated(FindPublisherRequest.class) FindPublisherRequest request) {

        return publisherRepository.findAllPublisherLikePublisherName(request.getName())
                .stream()
                .map(PublisherMapper.INSTANCE::mapToDto)
                .map(publisher -> ((SimplePublisher) publisher))
                .collect(Collectors.toSet());
    }
}
