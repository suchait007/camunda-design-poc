import { Component } from '@angular/core';
import { TaskListComponent } from './task-list/task-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [TaskListComponent],
  template: `
    <div>
      <h1>Camunda Task Manager</h1>
      <app-task-list></app-task-list>
    </div>
  `,
})
export class AppComponent {}
