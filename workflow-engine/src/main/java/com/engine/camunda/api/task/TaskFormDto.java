package com.engine.camunda.api.task;


import lombok.Data;

import java.util.Map;

@Data
public class TaskFormDto {

    private Map<String, Object> formVariables;
}
