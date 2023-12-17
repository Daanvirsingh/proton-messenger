package com.example.protonmessenger.model;

public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;

    public ApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters

    // Success Response
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("success", null, data);
    }

    // Success Response with message
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("success", message, data);
    }

    // Failure Response
    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>("error", message, null);
    }
}
