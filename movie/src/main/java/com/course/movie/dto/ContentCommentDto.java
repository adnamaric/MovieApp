package com.course.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentCommentDto {
    private String Comment;
    private Integer ContentID;
    private Integer UserID;
}
