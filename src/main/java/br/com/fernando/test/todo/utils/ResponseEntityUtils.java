package br.com.fernando.test.todo.utils;

import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

public final class ResponseEntityUtils {

    private ResponseEntityUtils() {}

    public static ResponseEntity ok(Object body) {
        return ResponseEntity.status(OK).body(body);
    }

    public static ResponseEntity created(Object body) {
        return ResponseEntity.status(CREATED).body(body);
    }

    public static ResponseEntity notFound(Object body) {
        return ResponseEntity.status(NOT_FOUND).contentType(APPLICATION_JSON).body(body);
    }

    public static ResponseEntity noContent() {
        return ResponseEntity.status(NO_CONTENT).build();
    }
}