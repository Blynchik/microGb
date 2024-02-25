package com.micro.task.util;

import com.micro.task.model.*;

public class TaskFactory {
    public Task buildTask(String descr, Type type) {

        if (type.equals(Type.ORDINARY)) {
            return OrdinaryTask.builder()
                    .descr(descr)
                    .status(Status.NOT_STARTED)
                    .build();

        } else if (type.equals(Type.URGENT)) {
            return UrgentTask.builder()
                    .descr(descr)
                    .status(Status.NOT_STARTED)
                    .build();

        } else throw new IllegalArgumentException();
    }
}
