package com.bwcompany.publisher.presentation.http.request;

import com.bwcompany.publisher.dto.Publisher;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = Publisher.class)
public interface CreatePublisherRequest {
}
