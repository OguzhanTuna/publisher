package com.bwcompany.publisher.mapper;

import com.bwcompany.publisher.domain.PublisherEntity;
import com.bwcompany.publisher.dto.Publisher;
import com.bwcompany.publisher.presentation.http.request.CreatePublisherRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);
    
    Publisher mapToDto(PublisherEntity authorEntity);


    PublisherEntity create(CreatePublisherRequest request);
}
