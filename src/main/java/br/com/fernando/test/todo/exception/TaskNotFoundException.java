package br.com.fernando.test.todo.exception;

import static java.lang.String.format;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }

    public String getMessage() {
        return format("{\"message\": \"%s\"}", super.getMessage());
    }
}
