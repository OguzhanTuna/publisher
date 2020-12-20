package com.bwcompany.publisher.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_publisher")
@Getter
@Setter
public class PublisherEntity {

    @Id
    @SequenceGenerator(name = "publisherSeqGen", sequenceName = "seq_publisher_id",allocationSize = 1)
    @GeneratedValue(generator = "publisherSeqGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String explanation;

    @OneToMany(mappedBy = "publisher")
    private List<AuthorEntity> authors = new ArrayList<>();
}
