import manager.TaskManager;
import task.Epic;
import task.Subtask;
import task.Task;
import task.TaskStatus;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        Task task1 = new Task("task.Task 1","task.Task description 1",TaskStatus.NEW);
        Epic epic1 = new Epic("task.Epic 1","Epic1 description 1", TaskStatus.NEW);
        Epic epic2 = new Epic("task.Epic 2","Epic1 description 2", TaskStatus.NEW);
        manager.createEpic(epic1);
        manager.createEpic(epic2);
        Subtask subtask1 = new Subtask("SubTask 1","SubTask description 1",TaskStatus.NEW, epic1.getTaskId());
        Subtask subtask2 = new Subtask("SubTask 2","SubTask description 2",TaskStatus.IN_PROGRESS,epic1.getTaskId());
        Subtask subtask3 = new Subtask("SubTask 3","SubTask description 3",TaskStatus.IN_PROGRESS, epic2.getTaskId());
        Subtask subtask4 = new Subtask("SubTask 4","SubTask description 4",TaskStatus.IN_PROGRESS, epic2.getTaskId());
        subtask1 = manager.createSubTask(subtask1);
        subtask2 = manager.createSubTask(subtask2);
        subtask3 = manager.createSubTask(subtask3);
        subtask4 = manager.createSubTask(subtask4);
        System.out.println(epic1);
        System.out.println(epic2);
        subtask1.setTaskStatus(TaskStatus.IN_PROGRESS);
        System.out.println(subtask1);
        manager.updateSubTask(subtask1);
        System.out.println("-------");
        System.out.println(subtask1);
        System.out.println(subtask2);
        manager.updateEpic(1);
        System.out.println(epic1);
        System.out.println("All Tasks");
        manager.getAllTasks();
        System.out.println("All Subtasks");
        manager.getAllSubTasks();
        System.out.println("All Epics");
        manager.getAllEpics();
        manager.deleteAllTasks();
        manager.deleteAllSubtasks();
        manager.deleteAllEpics();
        manager.getTaskById(1);
        manager.getSubtaskById(1);
        manager.getEpicById(2);
        manager.deleteTaskById(1);
        manager.deleteSubtaskById(2);
        manager.deleteEpicById(2);
    }
}
