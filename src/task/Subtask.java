package task;

public class Subtask extends Task {
    private final int epicId;

    public Subtask(String taskName, String taskDescription, TaskStatus taskStatus, int epicId) {
        super(taskName, taskDescription, taskStatus);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
