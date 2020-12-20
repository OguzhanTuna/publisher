package com.bwcompany.publisher.dao;

import com.bwcompany.publisher.domain.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {

    @Query("select publisher from PublisherEntity publisher where publisher.name like '%:publisherName%'")
    List<PublisherEntity> findAllPublisherLikePublisherName(@Param("publisherName") String publisherName);
}
