package com.marvel.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Serie {
    @Id
    @GeneratedValue
    private Long neoId;
    @NonNull
    @Column(name = "serie_id")
    private Long sId;
    @NonNull
    private String name, resourceURI, thumbnail;
    @NonNull
    private Integer startYear, endYear;

    @ManyToOne
    @JoinColumn(name = "comic_id", referencedColumnName = "comic_id", insertable = false, updatable = false)
    private Comic comic;
}
