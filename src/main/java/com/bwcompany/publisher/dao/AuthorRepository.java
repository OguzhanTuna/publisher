package com.bwcompany.publisher.dao;

import com.bwcompany.publisher.domain.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>, CustomAuthorRepository {

}
