package com.micro.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.micro.task.dto.TaskDto;
import com.micro.task.model.Status;
import com.micro.task.model.Task;
import com.micro.task.service.TaskService;
import com.micro.task.service.TaskServiceImpl;
import com.micro.task.util.Converter;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;
    private final Converter converter;

    @Autowired
    public TaskController(TaskService taskService,
                          Converter converter) {
        this.taskService = taskService;
        this.converter = converter;
    }

    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAll() {
        return ResponseEntity.ok(taskService.findAll().stream()
                .map(converter::getDto)
                .toList());
    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskDto>> getByStatus(@RequestParam Status status) {
        return ResponseEntity.ok(taskService.findByStatus(status).stream()
                .map(converter::getDto)
                .toList());
    }

    @PostMapping()
    public ResponseEntity<TaskDto> create(@RequestBody Task task) {
        return ResponseEntity.ok(converter.getDto(taskService.create(task)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable Long id,
                                          @RequestParam Status status) {
        return ResponseEntity.ok(converter.getDto(taskService.update(id, status)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
