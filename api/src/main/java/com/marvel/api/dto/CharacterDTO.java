package com.marvel.api.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class CharacterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;
    private Thumbnail thumbnail;

    @Override
    public String toString() {
        return "HeroDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
