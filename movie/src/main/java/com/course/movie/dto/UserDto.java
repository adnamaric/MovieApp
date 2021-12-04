package com.course.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private Boolean active;
    private String firstName;
    private String LastName;
    private String address;
    private String email;

}
