package com.marvel.api.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Utils {

    @Value("${marvel.api.publickey}")
    private String publicKey;

    @Value("${marvel.api.privatekey}")
    private String privateKey;

    @Value("${java.home}")
    private String javaHome;


    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + privateKey + publicKey);
    }
}
