package com.micro.task.dto;

import lombok.Data;
import com.micro.task.model.Role;

import java.util.List;
import java.util.Set;

@Data
public class PerformerDto {
    private Long id;

    private String name;

    private List<Long> tasksId;

    private Set<Role> roles;
}
