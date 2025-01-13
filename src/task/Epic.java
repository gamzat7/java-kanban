package task;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private final List<Integer> subTaskIds = new ArrayList<>();

    public Epic(String taskName, String taskDescription, TaskStatus taskStatus) {
        super(taskName, taskDescription, taskStatus);
    }



    public List<Integer> getSubTaskIds() {
        return subTaskIds;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subTaskIds=" + subTaskIds +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
