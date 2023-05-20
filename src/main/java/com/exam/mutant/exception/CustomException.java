package com.exam.mutant.exception;

import lombok.Data;

@Data
public abstract class CustomException extends Exception {
    protected final String message;
}
