package com.Training_System.models;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private Long Student_id;
    private Long Course_id;
    private Timestamp Issued_date;
    private String Certificate_title;
}
