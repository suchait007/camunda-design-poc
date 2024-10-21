package com.engine.camunda.api.task;

import com.engine.camunda.service.CamundaTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.camunda.bpm.engine.rest.dto.task.TaskDto;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final CamundaTaskService camundaTaskService;

    // Get list of tasks assigned to a user
    @GetMapping("/get")
    public ResponseEntity<List<TaskDto>> getTasksByAssignee(@RequestParam("assignee") String assignee) {
        List<TaskDto> tasks = camundaTaskService.getTasksByAssignee(assignee);
        return ResponseEntity.ok(tasks);
    }

    // Assign task to a specific user
    @PostMapping("/{taskId}/assign")
    public ResponseEntity<Void> assignTask(@PathVariable("taskId") String taskId, @RequestParam String assignee) {
        camundaTaskService.assignTask(taskId, assignee);
        return ResponseEntity.noContent().build();
    }

    // Complete a task
    @PostMapping("/{taskId}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable("taskId") String taskId, @RequestBody TaskFormDto formDto) {
        camundaTaskService.completeTask(taskId, formDto);
        return ResponseEntity.noContent().build();
    }
}
