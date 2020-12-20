package com.bwcompany.publisher.dao.impl;

import com.bwcompany.publisher.dao.CustomAuthorRepository;
import com.bwcompany.publisher.domain.AuthorEntity;
import com.bwcompany.publisher.presentation.http.request.FindAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Repository
public class AuthorRepositoryImpl implements CustomAuthorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Stream<AuthorEntity> search(FindAuthorRequest request) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AuthorEntity> query = criteriaBuilder.createQuery(AuthorEntity.class);

        Root<AuthorEntity> from = query.from(AuthorEntity.class);

        Set<Predicate> predicates = new HashSet<>();

        Optional.ofNullable(request.getName())
                .filter(authorName -> !authorName.isEmpty())
                .ifPresent(authorName -> {

                    Predicate name = criteriaBuilder.like(from.get("name"), "%" + authorName + "%");
                    predicates.add(name);
                });

        Optional.ofNullable(request.getPublisherName())
                .filter(publisherName -> !publisherName.isEmpty())
                .ifPresent(authorName -> {

                    from.fetch("publisher", JoinType.INNER);

                    Predicate predicate = criteriaBuilder.like(from.get("publisher").get("name"), "%" + authorName + "%");

                    predicates.add(predicate);

                });

        query.where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(query).getResultStream();
    }
}
