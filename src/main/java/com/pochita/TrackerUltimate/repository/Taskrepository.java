package com.pochita.TrackerUltimate.repository;

import com.pochita.TrackerUltimate.entity.Task;
import com.pochita.TrackerUltimate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Taskrepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_Id(Long userId);
}
