package com.marvel.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponse {
    private String code;
    private String status;
    private Data data;

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}