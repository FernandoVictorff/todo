package br.com.fernando.test.todo.validator;

import br.com.fernando.test.todo.domain.dto.RequestTaskDTO;
import br.com.fernando.test.todo.repository.TaskRepository;
import org.springframework.stereotype.Component;

import static br.com.fernando.test.todo.validator.ValidatorConstants.*;
import static br.com.fernando.test.todo.validator.ValidatorUtils.*;

@Component
public class TaskValidator {
    private final TaskRepository taskRepository;

    public TaskValidator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void validate(Long id, RequestTaskDTO requestTaskDTO) {
        var validationErrors = new ValidationErrors();

        if (validateRequired(id, TASK_ID, validationErrors)) {
            validateTitle(requestTaskDTO.title(), validationErrors);
            validateDescription(requestTaskDTO.description(), validationErrors);
        }

        throwOnError(validationErrors);
    }

    public void validate(RequestTaskDTO requestTaskDTO) {
        var validationErrors = new ValidationErrors();

        validateTitle(requestTaskDTO.title(), validationErrors);
        validateDescription(requestTaskDTO.description(), validationErrors);

        throwOnError(validationErrors);
    }

    private boolean validateTitle(String title, ValidationErrors vallidationErrors) {
        return (
            validateRequired(title, TASK_TITLE, vallidationErrors) &&
            validateMaxLength(title, TASK_TITLE, TASK_TITLE_MAX_LENGTH, vallidationErrors)
        );
    }

    private boolean validateDescription(String description, ValidationErrors vallidationErrors) {
        return (
            validateRequired(description, TASK_DESCRIPTION, vallidationErrors) &&
            validateMaxLength(description, TASK_DESCRIPTION, TASK_DESCRIPTION_MAX_LENGTH, vallidationErrors)
        );
    }
}
