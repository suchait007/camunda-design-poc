package com.engine.camunda.service;


import com.engine.camunda.api.task.TaskFormDto;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.rest.dto.task.TaskDto;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CamundaTaskService {


    private final TaskService taskService;

    // Get tasks by assignee
    public List<TaskDto> getTasksByAssignee(String assignee) {
        TaskQuery query = taskService.createTaskQuery().taskAssignee(assignee);
        List<Task> tasks = query.list();

        return tasks.stream().map(TaskDto::new).collect(Collectors.toList());
    }

    // Assign task to a specific user
    public void assignTask(String taskId, String assignee) {
        validateTaskId(taskId);
        validateAssignee(assignee);
        taskService.setAssignee(taskId, assignee);
    }

    // Complete a task
    public void completeTask(String taskId, TaskFormDto formDto) {
        validateTaskId(taskId);
        validateFormDto(formDto);

        Map<String, Object> variables = formDto.getFormVariables();
        taskService.complete(taskId, variables);
    }

    // Validation methods
    private void validateTaskId(String taskId) {
        Optional<Task> task = Optional.ofNullable(taskService.createTaskQuery().taskId(taskId).singleResult());
        if (task.isEmpty()) {
            throw new IllegalArgumentException("Task ID not found: " + taskId);
        }
    }

    private void validateAssignee(String assignee) {
        if (assignee == null || assignee.trim().isEmpty()) {
            throw new IllegalArgumentException("Assignee cannot be null or empty");
        }
    }

    private void validateFormDto(TaskFormDto formDto) {
        if (formDto == null || formDto.getFormVariables() == null) {
            throw new IllegalArgumentException("Form data cannot be null");
        }
    }
}
