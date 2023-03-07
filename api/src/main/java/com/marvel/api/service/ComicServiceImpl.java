package com.marvel.api.service;

import com.marvel.api.client.ComicClient;
import com.marvel.api.dto.response.ComicDTO;
import com.marvel.api.entity.Comic;
import com.marvel.api.repository.ComicRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ComicServiceImpl implements ComicService {

    @Value("${marvel.api.publickey}")
    private String publicKey;

    @Value("${marvel.api.privatekey}")
    private String privateKey;

    private ComicClient client;

    private ComicRepository comicRepository;

    public ComicServiceImpl(ComicClient client, ComicRepository comicRepository) {
        this.client = client;
        this.comicRepository = comicRepository;
    }

    public ComicDTO findComicByHero(int hero) {
        Long timeStamp = new Date().getTime();
        return client.getAll(timeStamp, publicKey, buildHash(timeStamp), hero);
    }

    private String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + privateKey + publicKey);
    }

    public void createComic(int hero) {
        ComicDTO comicDTO = findComicByHero(hero);
        var commitDto = comicDTO.getData().getResults();
        Comic comic = new Comic();

        List<Comic> comicList = new ArrayList<>();
        commitDto.stream().forEach(c -> {
            comic.setName(c.getTitle());
            comic.setId(c.getId());
        });
        comicList.add(comic);
        comicRepository.saveAll(comicList);
    }
}
