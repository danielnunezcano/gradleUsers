package com.lookiero.infrastructure.dto;

public class ErrorDto {
    private Integer code;
    private String description;
    private String message;

    public ErrorDto(Integer code, String description, String message) {
        this.code = code;
        this.description = description;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
