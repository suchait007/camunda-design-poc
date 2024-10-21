package com.engine.camunda.api.task;


import lombok.Data;

@Data
public class TaskDto {

    private String id;
    private String name;
    private String assignee;

}
