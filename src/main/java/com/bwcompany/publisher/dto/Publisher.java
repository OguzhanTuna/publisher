package com.bwcompany.publisher.dto;

import com.bwcompany.publisher.presentation.SimplePublisher;
import com.bwcompany.publisher.presentation.http.request.CreatePublisherRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Publisher implements KeyPublisher, SimplePublisher, CreatePublisherRequest {

    private long id;
}
