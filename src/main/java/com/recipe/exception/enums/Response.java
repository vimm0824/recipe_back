package com.recipe.exception.enums;


import com.recipe.exception.CustomException;
import com.recipe.exception.CustomExceptionDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response<T> {

    private String resultCode;
    private T result;

    public static Response error(CustomException e) {
        return new Response<>("ERROR", CustomExceptionDto.of(e));
    }

    public static <T> Response<T> success(T resultObject) {
        return new Response<>("SUCCESS", resultObject);
    }
}

