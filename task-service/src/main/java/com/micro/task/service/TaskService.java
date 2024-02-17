package com.micro.task.service;

import com.micro.task.model.Status;
import com.micro.task.model.Task;

import java.util.List;

public interface TaskService {

    Task create(Task task);

    Task update(Long id, Status status);

    void delete(Long id);

    List<Task> findAll();

    List<Task> findByStatus(Status status);
}
