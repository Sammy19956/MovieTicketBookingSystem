package com.example.movieticketbookingsystem.usercase.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private String message;
    private boolean status = false;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm")
    private LocalDateTime createdAt;

    private T data;

    public ApiResponse(String message, boolean status, T data){
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ApiResponse(String message, boolean status){
        this.message = message;
        this.status = status;
    }

}
