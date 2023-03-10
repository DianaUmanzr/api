package com.marvel.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditListener.class)
public class Comic implements Auditable, Serializable {

    @Id
    @GeneratedValue
    private Long cId;

    @NonNull
    @Column(name = "comic_id")
    private Long id;

    private String name;

    @Embedded
    private Audit audit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comic")
    public List<Serie> series = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comic")
    public List<Story> stories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comic")
    public List<Creator> creators = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comic")
    public List<Hero> hero = new ArrayList<>();
}
