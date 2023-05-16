import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTaskLogComponent } from './create-task-log.component';

describe('CreateTaskLogComponent', () => {
  let component: CreateTaskLogComponent;
  let fixture: ComponentFixture<CreateTaskLogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateTaskLogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateTaskLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
