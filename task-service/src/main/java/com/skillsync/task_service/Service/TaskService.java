package com.skillsync.task_service.Service;

import com.skillsync.task_service.Entity.Task;
import com.skillsync.task_service.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepo.findById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepo.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            task.setPriority(updatedTask.getPriority());
            task.setAssignedUserId(updatedTask.getAssignedUserId());
            task.setProjectId(updatedTask.getProjectId());
            return taskRepo.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
