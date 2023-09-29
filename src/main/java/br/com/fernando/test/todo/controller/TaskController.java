package br.com.fernando.test.todo.controller;

import br.com.fernando.test.todo.domain.dto.RequestTaskDTO;
import br.com.fernando.test.todo.domain.dto.ResponseTaskDTO;
import br.com.fernando.test.todo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.fernando.test.todo.utils.ResponseEntityUtils.*;

@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody RequestTaskDTO requestTaskDTO) {
        return created(taskService.create(requestTaskDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseTaskDTO>> findAll() {
        return ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTaskDTO> findById(@PathVariable("id") Long id) {
        return ok(taskService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
        @PathVariable("id") Long id,
        @RequestBody RequestTaskDTO requestTaskDTO
    ) {
        taskService.update(id, requestTaskDTO);
        return noContent();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        taskService.delete(id);
        return noContent();
    }
}
