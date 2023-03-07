package com.marvel.api.repository;


import com.marvel.api.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Hero, Long> {
}
