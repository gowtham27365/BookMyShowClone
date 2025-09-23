package com.example.bookmyshow.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private long userId;
    private int amount;
    private ResponseStatus responseStatus;
}
