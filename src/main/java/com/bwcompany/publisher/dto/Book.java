package com.bwcompany.publisher.dto;

import com.bwcompany.publisher.presentation.SimpleBook;
import com.bwcompany.publisher.presentation.http.request.CreateBookRequest;
import com.bwcompany.publisher.presentation.http.request.FindBookRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book implements
        KeyBook,
        SimpleBook,
        CreateBookRequest,
        FindBookRequest {

    private long id;
    private String name;
    private String authorName;
}
