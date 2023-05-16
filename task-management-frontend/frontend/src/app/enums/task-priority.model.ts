export enum TaskPriorityLevel {
    HIGH = 'HIGH',
    MEDIUM = 'MEDIUM',
    LOW = 'LOW',
  }
// mapping
export const TaskPriorityLevelToLabel: Record<TaskPriorityLevel, string> = {
  [TaskPriorityLevel.HIGH]:"HIGH",
  [TaskPriorityLevel.MEDIUM]: "MEDIUM",
  [TaskPriorityLevel.LOW]: 'LOW',
};