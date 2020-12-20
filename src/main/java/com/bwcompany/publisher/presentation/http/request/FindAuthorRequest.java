package com.bwcompany.publisher.presentation.http.request;

import com.bwcompany.publisher.dto.Author;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = Author.class)
@JsonDeserialize(as = Author.class)
public interface FindAuthorRequest {

    String getName();

    String getPublisherName();

}
