import { TestBed } from '@angular/core/testing';

import { TaskCollectionService } from './task-collection.service';

describe('TaskCollectionService', () => {
  let service: TaskCollectionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TaskCollectionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
