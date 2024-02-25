package com.micro.task.controller;

import com.micro.task.dto.TaskDto;
import com.micro.task.model.Status;
import com.micro.task.model.Task;
import com.micro.task.model.Type;
import com.micro.task.repo.TaskRepo;
import com.micro.task.service.TaskManagerService;
import com.micro.task.service.TaskService;
import com.micro.task.util.Converter;
import com.micro.task.util.TaskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manager")
public class TaskManager implements TaskController {
    private final TaskService taskService;
    private final TaskFactory taskFactory;
    private final Converter converter;

    @Autowired
    public TaskManager(TaskRepo taskRepo,
                       Converter converter,
                       TaskFactory taskFactory) {
        this.taskService = TaskManagerService.getInstance(taskRepo);
        this.converter = converter;
        this.taskFactory = taskFactory;
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAll() {
        return ResponseEntity.ok(taskService.findAll().stream()
                .map(converter::getDto)
                .toList());
    }

    @Override
    @GetMapping("/status")
    public ResponseEntity<List<TaskDto>> getByStatus(@RequestParam Status status) {
        return ResponseEntity.ok(taskService.findByStatus(status).stream()
                .map(converter::getDto)
                .toList());
    }

    @Override
    @PostMapping()
    public ResponseEntity<TaskDto> create(@RequestBody Task task) {
        return ResponseEntity.ok(converter.getDto(
                taskService.create(
                        taskFactory.buildTask(task.getDescr(),
                                task.getDescr().length() % 2 == 0 ? Type.ORDINARY : Type.URGENT)
                )));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable Long id,
                                          @RequestParam Status status) {
        return ResponseEntity.ok(converter.getDto(taskService.update(id, status)));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
