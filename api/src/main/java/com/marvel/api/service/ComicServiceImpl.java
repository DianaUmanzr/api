package com.marvel.api.service;

import com.marvel.api.client.ComicClient;
import com.marvel.api.dto.response.ComicDTO;
import java.util.Date;
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

    public ComicServiceImpl(ComicClient client) {
        this.client = client;
    }

    public ComicDTO findComicByHero(int character) {
        Long timeStamp = new Date().getTime();

        return client.getAll(timeStamp, publicKey, buildHash(timeStamp), character);
    }

    private String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + privateKey + publicKey);
    }
}
