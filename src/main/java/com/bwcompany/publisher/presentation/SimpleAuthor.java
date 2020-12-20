package com.bwcompany.publisher.presentation;

import com.bwcompany.publisher.dto.Author;
import com.bwcompany.publisher.dto.KeyAuthor;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = Author.class)
@JsonDeserialize(as = Author.class)
public interface SimpleAuthor extends KeyAuthor {

    String getName();

    String getLastName();

    default String getFullName() {
        return getName() + " " + getLastName();
    }

    default <T> T unwrap(Class<T> type) {
        return type.cast(this);
    }
}
