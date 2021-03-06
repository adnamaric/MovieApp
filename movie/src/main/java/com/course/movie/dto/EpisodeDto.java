package com.course.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
	  private String EpisodeName;
	  private Integer Duration;
	  private Integer EpisodeNumber;
	   private Integer SeasonID;

}
