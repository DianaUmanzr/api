package com.marvel.api.dto.response;

import lombok.Data;

@Data
public class ComicDTO {
	private String copyright;
	private String attributionHTML;
	
	private DataDTO data;
}
