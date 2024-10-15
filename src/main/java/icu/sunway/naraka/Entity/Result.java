package icu.sunway.naraka.Entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;
}
