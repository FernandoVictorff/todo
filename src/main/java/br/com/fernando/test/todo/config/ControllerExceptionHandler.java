package br.com.fernando.test.todo.config;

import br.com.fernando.test.todo.domain.dto.ResponseError;
import br.com.fernando.test.todo.exception.InvalidRequestExcepiton;
import br.com.fernando.test.todo.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.fernando.test.todo.utils.ResponseEntityUtils.notFound;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity handleNotFoundException(Exception exception) {
        return notFound(exception.getMessage());
    }

    @ExceptionHandler(InvalidRequestExcepiton.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ResponseError> handleInvalidRequestException(InvalidRequestExcepiton excepiton) {
        return excepiton
            .getValidationErrors()
            .stream()
            .map(e -> new ResponseError(e.getField(), e.getErrorCode()))
            .collect(Collectors.toList());
    }
}