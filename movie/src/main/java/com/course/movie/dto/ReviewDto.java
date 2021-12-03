package com.course.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private int UserID;
    private int ContentID;
    private Integer rating;
    private Boolean favourite;
}
