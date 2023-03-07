package com.marvel.api.entity;

import com.marvel.api.dto.response.Thumbnail;
import java.io.Serializable;
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
public class Hero implements Serializable {
    @Id
    @GeneratedValue
    private Long hId;

    @NonNull
    @Column(name = "hero_id")
    private Long id;

    @NonNull
    private String name;

    private String description;

    private Thumbnail thumbnail;

    @ManyToOne
    @JoinColumn(name = "comic_id", referencedColumnName = "comic_id", insertable = false, updatable = false)
    private Comic comic;
}
