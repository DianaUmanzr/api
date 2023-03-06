package com.marvel.api.client;

import com.marvel.api.dto.response.ComicDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marvel", url = "${marvel.api.url}/v1/public")
public interface ComicClient {
    @GetMapping("/comics")
    public ComicDTO getAll(@RequestParam(value = "ts") Long timeStamp,
                           @RequestParam(value = "apikey") String publicKey, @RequestParam(value = "hash") String hashMD5,
                           @RequestParam(value = "characters") int character);
}
