package com.marvel.api.repository;

import com.marvel.api.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Long> {

    Comic findByName(String name);

    Iterable<Comic> findByNameLike(String name);
}
