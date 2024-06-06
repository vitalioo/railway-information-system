package com.example.railwayinformationsystem.repository;

import com.example.railwayinformationsystem.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);
}
