package br.com.samuel.orderapi.service.response;

import org.springframework.http.HttpStatus;

public enum StatusErrorEnum {

    NOT_FOUND("001", "Product Not Found!", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;

    StatusErrorEnum(String code, String message, HttpStatus status) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
