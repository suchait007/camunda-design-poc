import { Component, inject } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
// @ts-ignore
import { CamundaTaskService } from '../camunda-task.service';
import { TaskFormComponent } from '../task-form/task-form.component';
import { FormsModule } from '@angular/forms';
import {MatList, MatListItem} from "@angular/material/list";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";


@Component({
  selector: 'app-task-list',
  standalone: true,
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css'],
  imports: [CommonModule, HttpClientModule, FormsModule, TaskFormComponent, MatListItem, MatCardContent, MatList, MatCardTitle, MatCardHeader, MatCard, MatToolbar],
})
export class TaskListComponent {
  tasks: any[] = [];
  selectedTaskId: string | null = null;  // Allow null here

  private taskService = inject(CamundaTaskService);

  constructor() {
    this.loadTasks();
  }

  loadTasks(): void {
    const assignee = 'demo'; // Replace with dynamic assignee
    // @ts-ignore
    this.taskService.getUserTasks(assignee).subscribe((data) => {
      this.tasks = data;
    });
  }

  selectTask(taskId: string): void {
    this.selectedTaskId = taskId;
  }
}
