package com.api.product.exception.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {

    private List<String> errors;

    public ValidationErrorResponse(String message, int statusCode, String path, List<String> errors) {
        super(message, statusCode, path);
        this.errors = errors;
    }
}
