package com.Training_System.service.impl;

import com.Training_System.model.DTO.InstructorDTO;
import com.Training_System.model.AppUser;
import com.Training_System.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Instructor;
import com.Training_System.repository.InstructorRepository;
import com.Training_System.service.interfaces.IInstructorService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
@RequiredArgsConstructor
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    private final AuthRepository authRepository;


    public void registerInstructor(InstructorDTO instructorDTO) {
        String hash = new BCryptPasswordEncoder().encode(instructorDTO.getPassword());

        AppUser user = new AppUser();
        user.setUsername(instructorDTO.getUsername());
        user.setPassword(hash);
        user.setFirstName(instructorDTO.getFirstName());
        user.setLastName(instructorDTO.getLastName());
        user.setGender(instructorDTO.getGender());
        user.setRole("INSTRUCTOR");
        authRepository.save(user);

        Instructor instructor = new Instructor();
        instructor.setDepartment(instructorDTO.getDepartment());
        instructor.setLanguageSpoken(instructorDTO.getLanguageSpoken());
        instructor.setUser(user);
        instructorRepository.save(instructor);

    }

    //@Override
    public void updateInstructor(String Language_spoken, Long id) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if (instructorOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor " + id + " not found");

        Instructor ins = instructorOptional.get();
        ins.setLanguageSpoken(Language_spoken);
        instructorRepository.save(ins);
    }

    //@Override
    public void deleteInstructor(Long id) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if (instructorOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor " + id + " not found");
        instructorRepository.deleteById(id);
    }
}
