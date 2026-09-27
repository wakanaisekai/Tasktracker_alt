package com.pochita.TrackerUltimate.controller;

import com.pochita.TrackerUltimate.entity.Task;
import com.pochita.TrackerUltimate.entity.User;
import com.pochita.TrackerUltimate.repository.Userrepository;
import com.pochita.TrackerUltimate.service.Taskservices;
import com.pochita.TrackerUltimate.service.Userservices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{user_id}/tasks")
public class TaskController {
    private final Taskservices taskservices;

    public TaskController(Taskservices taskservices){
        this.taskservices = taskservices;
    }
    @GetMapping
    public List<Task> getTasks(@PathVariable Long user_id){
        return taskservices.getTasks(user_id);
    }

    @PostMapping
    public void createTask(@RequestBody Task task, @PathVariable Long user_id){
        taskservices.createTask(task, user_id);
    }
    @DeleteMapping("/{task_id}")
    public void DeleteTask(@PathVariable Long task_id){
        taskservices.deleteTask(task_id);
    }

    @PostMapping("/{task_id}/update")
    public void UpdateTask(@PathVariable Long task_id, @RequestBody Task task){
        taskservices.updateTask(task, task_id);
    }
}
