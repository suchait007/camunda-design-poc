import { TestBed } from '@angular/core/testing';

import { CamundaTaskService } from './camunda-task.service';

describe('CamundaTaskService', () => {
  let service: CamundaTaskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CamundaTaskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
