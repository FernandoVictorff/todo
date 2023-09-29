package br.com.fernando.test.todo.domain.dto;

import br.com.fernando.test.todo.domain.entity.Task;

public record ResponseTaskDTO(
    Long id,
    String title,
    String description
) {
    public static ResponseTaskDTO fromModel(Task task) {
        return new ResponseTaskDTO(task.getId(), task.getTitle(), task.getDescription());
    }
}
