import { Component, Input, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
// @ts-ignore
import { CamundaTaskService } from '../camunda-task.service';

@Component({
  selector: 'app-task-form',
  standalone: true,
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css'],
  imports: [FormsModule, CommonModule],
})
export class TaskFormComponent {
  @Input() taskId!: string | null;  // <-- Allow taskId to be string or null
  formVariables: any = {
    name: '',
    age: 0,
  };
  private taskService = inject(CamundaTaskService);

  completeTask(): void {
    if (this.taskId) { // Only proceed if taskId is not null
      // @ts-ignore
      this.taskService.completeTask(this.taskId, this.formVariables).subscribe(() => {
        alert('Task completed successfully');
      });
    }
  }
}
