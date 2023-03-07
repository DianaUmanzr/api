package com.marvel.api.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Creator {

    @Id
    @GeneratedValue
    private Long crId;
    @NonNull
    @Column(name = "creator_id")
    private Long id;
    @NonNull
    private String name, resourceURI;

    @ManyToOne
    @JoinColumn(name = "comic_id", referencedColumnName = "comic_id", insertable = false, updatable = false)
    private Comic comic;
}
