package com.bwcompany.publisher.presentation.http.request;

import com.bwcompany.publisher.dto.Book;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;

@JsonSerialize(as = Book.class)
public interface FindBookRequest {

    String getName();

    String getAuthorName();

    @AssertTrue(message = "Any find one or more search parameter", groups = FindBookRequest.class)
    default boolean isValidScriptOnFindBookRequest() {
        return StringUtils.isNotEmpty(getName()) || StringUtils.isNotEmpty(getAuthorName());
    }
}
