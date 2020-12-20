package com.bwcompany.publisher.presentation;

import com.bwcompany.publisher.dto.KeyPublisher;
import com.bwcompany.publisher.dto.Publisher;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = Publisher.class)
public interface SimplePublisher extends KeyPublisher {
}
