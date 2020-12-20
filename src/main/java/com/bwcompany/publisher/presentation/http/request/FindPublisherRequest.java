package com.bwcompany.publisher.presentation.http.request;

import com.bwcompany.publisher.dto.Publisher;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;

@JsonSerialize(as = Publisher.class)
public interface FindPublisherRequest {

    @NotEmpty(groups = FindPublisherRequest.class)
    String getName();

}
