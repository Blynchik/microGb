package com.micro.task.dto;

import lombok.Builder;
import lombok.Data;
import com.micro.task.model.Status;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class TaskDto {
    private Long id;

    private String descr;

    private Status status;

    private Date createdAt;

    private List<Long> performersId;
}
