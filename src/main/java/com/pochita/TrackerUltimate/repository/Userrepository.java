package com.pochita.TrackerUltimate.repository;

import com.pochita.TrackerUltimate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User, Long> {
}
