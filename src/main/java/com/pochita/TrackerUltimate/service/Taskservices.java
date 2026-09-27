package com.pochita.TrackerUltimate.service;

import com.pochita.TrackerUltimate.entity.Task;
import com.pochita.TrackerUltimate.entity.User;
import com.pochita.TrackerUltimate.repository.Taskrepository;
import com.pochita.TrackerUltimate.repository.Userrepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class Taskservices {

    private final Taskrepository taskrepository;
    private final Userrepository userrepository;
    public Taskservices(Taskrepository taskrepository, Userrepository userrepository) {
        this.taskrepository = taskrepository;
        this.userrepository = userrepository;
    }

    public List<Task> getTasks(@PathVariable Long user_id){
        return taskrepository.findByUser_Id(user_id);
    }
    public Task createTask(Task task, Long userId) {
        User user = userrepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);
        return taskrepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskrepository.deleteById(taskId);
    }

    public void updateTask(Task task, Long taskId) {
        Task curtask = taskrepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        curtask.setName(task.getName());

        taskrepository.save(curtask);
    }


}
