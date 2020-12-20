package com.bwcompany.publisher.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "t_author")
@Getter
@Setter
public class AuthorEntity {

    @Id
    @SequenceGenerator(name = "authorSeqGen", sequenceName = "seq_author_id", allocationSize = 1)
    @GeneratedValue(generator = "authorSeqGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    //Default naming strategy is supported but explicit best practise
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private OffsetDateTime birthDate;

    @Column(name = "publisher_id")
    private Long publisherId;

    @ManyToOne(optional = true)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PublisherEntity publisher;

}
