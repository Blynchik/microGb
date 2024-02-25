package com.micro.task.util;

import com.micro.task.model.Performer;
import org.springframework.stereotype.Component;
import com.micro.task.dto.TaskDto;
import com.micro.task.model.Task;

@Component
public class Converter {

        public TaskDto getDto(Task task) {
            return TaskDto.builder()
                .id(task.getId())
                .descr(task.getDescr())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .build();

    }
}
