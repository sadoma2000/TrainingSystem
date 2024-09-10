package com.Training_System.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InstructorDTO {
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String gender;

    private String department;
    private String languageSpoken;

}
