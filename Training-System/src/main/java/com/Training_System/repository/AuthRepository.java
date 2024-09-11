package com.Training_System.repository;

import com.Training_System.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AppUser,Integer> {
    AppUser  findUserById(Integer id);
    AppUser findByUsername(String username);
}
