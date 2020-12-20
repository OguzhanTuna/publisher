package com.bwcompany.publisher.dto;

import com.bwcompany.publisher.presentation.SimpleAuthor;
import com.bwcompany.publisher.presentation.http.request.CreateAuthorRequest;
import com.bwcompany.publisher.presentation.http.request.FindAuthorRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.web.ProjectedPayload;

import java.time.OffsetDateTime;

@Getter
@Setter
@ProjectedPayload
public class Author implements KeyAuthor, CreateAuthorRequest, SimpleAuthor, FindAuthorRequest {

    private long id;
    private String name;
    private String lastName;
    private OffsetDateTime birthDate;

    private String publisherName;


}
