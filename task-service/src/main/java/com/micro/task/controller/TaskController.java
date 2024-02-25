package com.micro.task.controller;

import com.micro.task.dto.TaskDto;
import com.micro.task.model.Status;
import com.micro.task.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskController {

    ResponseEntity<List<TaskDto>> getAll();

    ResponseEntity<List<TaskDto>> getByStatus(Status status);

    ResponseEntity<TaskDto> create(Task task);

    ResponseEntity<TaskDto> update(Long id, Status status);

    ResponseEntity<HttpStatus> delete(Long id);
}
