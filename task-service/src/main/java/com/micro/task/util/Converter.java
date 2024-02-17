package com.micro.task.util;

import com.micro.task.model.Performer;
import org.springframework.stereotype.Component;
import com.micro.task.dto.TaskDto;
import com.micro.task.model.Task;

@Component
public class Converter {

        public TaskDto getDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setDescr(task.getDescr());
        dto.setStatus(task.getStatus());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setPerformersId(task.getPerformers().stream()
                .map(Performer::getId).toList());
        return dto;
    }
}
