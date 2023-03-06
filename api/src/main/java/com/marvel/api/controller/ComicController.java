package com.marvel.api.controller;

import com.marvel.api.dto.response.ComicDTO;
import com.marvel.api.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService service;

    public ComicController(ComicService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ComicDTO findAll(@RequestParam(name = "heroId") int heroId) {
        return service.findComicByHero(heroId);
    }
}
