package manager;

import task.Epic;
import task.Subtask;
import task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static task.TaskStatus.DONE;
import static task.TaskStatus.IN_PROGRESS;
import static task.TaskStatus.NEW;
public class TaskManager {

    Map<Integer, Task> tasks = new HashMap<>();
    Map<Integer, Subtask> subtasks = new HashMap<>();
    Map<Integer, Epic> epics = new HashMap<>();
    private int generateId = 0;
    private int generateIds(){
        return ++generateId;
    }
    public Task createTask(Task task){
        if (task.getTaskId() >0) {
            return task;
        }
        int newTaskId = generateIds();
        task.setTaskId(newTaskId);
        tasks.put(task.getTaskId(),task);
        return task;
    }
    public Task updateTask(Task task){
        if (task.getTaskId() == 0){
            return task;
        }
        if (!tasks.containsKey(task.getTaskId())){
            return task;
        }
        tasks.put(task.getTaskId(), task);
        return task;
    }
    public Subtask createSubTask(Subtask subtask){
        if (subtask.getTaskId() >0) {
            return subtask;
        }
        if (subtask.getEpicId() == 0){
            return subtask;
        }
        if (!epics.containsKey(subtask.getEpicId())) {
            return subtask;
        }

        int newSubTaskId = generateIds();
        subtask.setTaskId(newSubTaskId);
        subtasks.put(subtask.getTaskId(),subtask);
        Epic epic =epics.get(subtask.getEpicId());
        epic.getSubTaskIds().add(newSubTaskId);
        return subtask;

    }
    public Subtask updateSubTask(Subtask subtask){
        if (subtask.getTaskId() == 0){
            return subtask;
        }
        if (!subtasks.containsKey(subtask.getTaskId())){
            return subtask;
        }
        subtasks.put(subtask.getTaskId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        return subtask;

    }
    public Epic createEpic(Epic epic){
        if (epic.getTaskId() >0) {
            return epic;
        }
        int newEpicId = generateIds();
        epic.setTaskId(newEpicId);
        epics.put(epic.getTaskId(),epic);
        return epic;
    }
    public void updateEpic (int epicid) {

        int doneStatus = 0;
        int progressStatus = 0;
        int newStatus = 0;
        if (epics.containsKey(epicid)){
            Epic epic = epics.get(epicid);
            List<Integer> subtaskIds = new ArrayList<>();
            subtaskIds =epic.getSubTaskIds();

            for (int id:subtaskIds){
                Subtask subtask = subtasks.get(id);
                if (subtask.getTaskStatus().equals(IN_PROGRESS)){
                    progressStatus++;

                } else if (subtask.getTaskStatus().equals(DONE)){
                    doneStatus++;

                } else if (subtask.getTaskStatus().equals(NEW)){
                    newStatus++;
                }
            }
            if (newStatus > 0) {
                epic.setTaskStatus(NEW);
            } else if ((newStatus==0) && (progressStatus > doneStatus)) {
                epic.setTaskStatus(IN_PROGRESS);
            } else if ((newStatus==0) && (progressStatus==0) && (doneStatus>0)){
                epic.setTaskStatus(DONE);
            }
            epics.remove(epicid);
            epics.put(epicid,epic);
        }
    }

    public void getAllTasks( ) {

        for (Integer key : tasks.keySet()) {
            Task task = tasks.get(key);
            System.out.println(task);
        }

    }
    public void getAllSubTasks( ) {

        for (Integer key : subtasks.keySet()) {
            Subtask subtask = subtasks.get(key);
            System.out.println(subtask);
        }

    }
    public void getAllEpics( ) {

        for (Integer key : epics.keySet()) {
            Epic epic = epics.get(key);
            System.out.println(epic);
        }

    }
    public void deleteAllTasks( ) {

        tasks.clear();

    }
    public void deleteAllSubtasks(){
        subtasks.clear();
    }
    public void deleteAllEpics(){
        epics.clear();
    }
    public void getTaskById (Integer id) {

        if (tasks.containsKey(id)){
            Task task = tasks.get(id);
            System.out.println(task);
        }

    }
    public void getSubtaskById (Integer id) {

        if (subtasks.containsKey(id)){
            Subtask subtask = subtasks.get(id);
            System.out.println(subtask);
        }

    }
    public void getEpicById (Integer id) {

        if (epics.containsKey(id)){
            Epic epic = epics.get(id);
            System.out.println(epic);
        }

    }
    public void deleteTaskById (Integer id) {

        if (tasks.containsKey(id)){
            tasks.remove(id);
        }

    }
    public void deleteSubtaskById (Integer id) {

        if (subtasks.containsKey(id)){
            subtasks.remove(id);
        }
    }
    public void deleteEpicById (Integer id) {

        if (epics.containsKey(id)){
            epics.remove(id);
        }
    }
}
