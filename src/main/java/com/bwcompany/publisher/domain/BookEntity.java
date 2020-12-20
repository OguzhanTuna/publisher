package com.bwcompany.publisher.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_book")
@Getter
@Setter
public class BookEntity {

    @Id
    @SequenceGenerator(name = "bookSeqGen", sequenceName = "seq_book_id", allocationSize = 1)
    @GeneratedValue(generator = "bookSeqGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    @Column(name = "sub_name")
    private String subName;

    private String series;
    private String isbn;

    private String explanation;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

}


