package com.example.baseapi.Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse<T> {
    private String message;
    private T data;
    private String Token;

    public AuthResponse (String message, T data, String Token){
        this.message = message;
        this.data = data;
        this.Token = Token;
    }
}
