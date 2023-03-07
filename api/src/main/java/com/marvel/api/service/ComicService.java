package com.marvel.api.service;

import com.marvel.api.dto.response.ComicDTO;

public interface ComicService {
    ComicDTO findComicByHero(int hero);

    void createComic(int hero);
}
