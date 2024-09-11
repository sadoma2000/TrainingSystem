package com.Training_System.service.impl;


import com.Training_System.model.AppUser;
import com.Training_System.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


//FOR TESTS ONLY
@Service
@RequiredArgsConstructor
public class AdminService {

    private final AuthRepository authRepository;


        public void registerAdmin(AppUser user) {
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setRole("ADMIN");
        user.setPassword(hash);
        authRepository.save(user);
    }
}
