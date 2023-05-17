import { TaskPriorityLevel } from "./enums/task-priority.model";
// import { taskStatus } from "./enums/task-status.model";
import { TaskCollection } from "./task-collection";

export class Task {
    id!: string;
    taskName!: string;
    description!: string;
    createdAt!: string;
    dueDate!: string;
    expectedTime!: string;
    taskPriorityLevel!: string;
    taskStatus!: string
    hasReminder!: string;
    taskCollection!: TaskCollection;
}
