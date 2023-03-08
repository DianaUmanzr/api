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
public class Story {
    @Id
    @GeneratedValue
    private Long sId;

    @NonNull
    @Column(name = "story_id")
    private Long id;
    @NonNull
    private String name, resourceURI, type;

    @ManyToOne
    @JoinColumn(name = "comic_id", referencedColumnName = "comic_id", insertable = false, updatable = false)
    private Comic comic;
}
