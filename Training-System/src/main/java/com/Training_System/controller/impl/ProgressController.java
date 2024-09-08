package com.Training_System.controller.impl;


import com.Training_System.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Training_System.model.Progress;
import com.Training_System.service.impl.ProgressService;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

	@Autowired
	private ProgressService progressService;

	//  ****************************************************  GET  ****************************************************
	@GetMapping("/get-all")
	public ResponseEntity getAllProgress() {
		return ResponseEntity.status(200).body(progressService.getAllProgress());
	}

	@GetMapping("/get-by-Progress/{studentId}")
	public ResponseEntity getProgressByStudentId(@PathVariable Long studentId) {
		return ResponseEntity.status(200).body(progressService.getProgressByStudentId(studentId));
	}

	@GetMapping("/get-by-id/{id}")
    public ResponseEntity getProgressById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(progressService.getProgressById(id));
	}

	//  ***************************************************  POST  ****************************************************
	@PostMapping("/add")
	public ResponseEntity addProgress(@RequestBody Progress progress) {
		progressService.addProgress(progress);
		return ResponseEntity.status(201).body("Progress added successfully");
	}

	//  ****************************************************  PUT  ****************************************************
	@PutMapping("/update")
	public ResponseEntity updateProgress(@RequestBody Progress progress) {
		progressService.updateProgress(progress);
		return ResponseEntity.status(201).body("Progress updated successfully");
	}

	//  **************************************************  DELETE  ***************************************************
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteProgress(@PathVariable Long id) {
		progressService.deleteProgress(id);
		return ResponseEntity.status(201).body("Progress deleted successfully");
	}

}

