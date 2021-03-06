package com.course.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {
	private String Title;
	private Integer Year;
	private Integer Duration;
    private Integer ContentTypeID;
    private Integer LanguageID;
    private Integer CountryID;

}
