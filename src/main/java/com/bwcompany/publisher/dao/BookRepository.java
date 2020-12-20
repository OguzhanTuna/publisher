package com.bwcompany.publisher.dao;

import com.bwcompany.publisher.domain.BookEntity;
import com.bwcompany.publisher.presentation.http.request.FindBookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("select book from BookEntity book where book.author.name like '%:authorName%'")
    List<BookEntity> findAllLikeAuthorName(String authorName);

    @Query(
            "select book from BookEntity book where " +
                    "( false = :#{#request.name.isEmpty()} and book.name like '%:#{#request.name}%') " +
                    "and ( false = :#{#request.authorName.isEmpty()} and book.author.name like '%:#{#request.authorName}%') "
    )
    List<BookEntity> findAll(FindBookRequest request);

}
