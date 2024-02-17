package com.micro.task.util;

import org.springframework.stereotype.Component;
import com.micro.task.dto.PerformerDto;
import com.micro.task.model.Performer;
import com.micro.task.model.Task;

@Component
public class Converter {

    public PerformerDto getDto(Performer performer) {
        PerformerDto dto = new PerformerDto();
        dto.setId(performer.getId());
        dto.setName(performer.getName());
        dto.setTasksId(performer.getTasks().stream()
                .map(Task::getId).toList());
        dto.setRoles(performer.getRoles());
        return dto;
    }
}
