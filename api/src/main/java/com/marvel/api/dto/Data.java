package com.marvel.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private int total;
    private CharacterDTO[] results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public CharacterDTO[] getResults() {
        return results;
    }

    public void setResults(CharacterDTO[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "total=" + total +
                '}';
    }
}