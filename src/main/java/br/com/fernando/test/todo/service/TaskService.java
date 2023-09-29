package br.com.fernando.test.todo.service;

import br.com.fernando.test.todo.domain.dto.RequestTaskDTO;
import br.com.fernando.test.todo.domain.dto.ResponseTaskDTO;
import br.com.fernando.test.todo.domain.entity.Task;
import br.com.fernando.test.todo.exception.TaskNotFoundException;
import br.com.fernando.test.todo.repository.TaskRepository;
import br.com.fernando.test.todo.validator.TaskValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskValidator taskValidator;

    public TaskService(
        TaskRepository taskRepository,
        TaskValidator taskValidator
    ) {
        this.taskRepository = taskRepository;
        this.taskValidator = taskValidator;
    }

    public ResponseTaskDTO create(RequestTaskDTO requestTaskDTO) {
        taskValidator.validate(requestTaskDTO);
        return ResponseTaskDTO.fromModel(
            taskRepository.save(
                Task.newBuilder()
                    .title(requestTaskDTO.title())
                    .description(requestTaskDTO.description())
                    .build()
            )
        );
    }

    public List<ResponseTaskDTO> findAll() {
        return taskRepository.findAll().stream().map(ResponseTaskDTO::fromModel).collect(Collectors.toList());
    }

    public ResponseTaskDTO findById(Long id) {
        return ResponseTaskDTO.fromModel(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found: " + id)));
    }

    public void update(Long id, RequestTaskDTO requestTaskDTO) {
        taskValidator.validate(id, requestTaskDTO);
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found: " + id));
        taskRepository.save(
            Task.newBuilder()
                .id(id)
                .title(requestTaskDTO.title())
                .description(requestTaskDTO.description())
                .build()
        );
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) throw new TaskNotFoundException("Task not found: " + id);
        taskRepository.deleteById(id);
    }
}
