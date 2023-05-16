import { TaskPriorityLevel } from "./enums/task-priority.model";
import { taskStatus } from "./enums/task-status.model";
import { TaskCollection } from "./task-collection";

export class Task {
    id!: number;
    taskName!: string;
    description!: string;
    createdAt!: Date;
    dueDate!: Date;
    expectedTime!: Number;
    taskPriorityLevel!: TaskPriorityLevel;
    taskStatus!: taskStatus;
    hasReminder!: Boolean;
    taskCollection!: TaskCollection;
}
