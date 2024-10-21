import { Injectable } from '@angular/core';
import {HttpClient, provideHttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CamundaTaskService {
  private apiUrl = 'http://localhost:8080/api/tasks/';

  constructor(private http: HttpClient) {}

  getUserTasks(assignee: string): Observable<any> {
    return this.http.get(`${this.apiUrl}get?assignee=${assignee}`);
  }

  completeTask(taskId: string, formVariables: any): Observable<any> {

    const payload = {
      formVariables: formVariables, // Send the form variables as part of the request
    };

    return this.http.post(`${this.apiUrl}${taskId}/complete`, payload);
  }
}
