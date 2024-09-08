package com.Training_System.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/getAllProgress")
	public List<Progress> getAllProgress() {
		return progressService.getAllProgress();
	}

	@GetMapping("/getProgressByStudentId/{studentId}")
	public List<Progress> getProgressByStudentId(@PathVariable Long studentId) {
		return progressService.getProgressByStudentId(studentId);
	}

	@GetMapping("/getProgressById/{id}")
	public Progress getProgressById(@PathVariable Long id) {
		return progressService.getProgressById(id);
	}

	@PostMapping("/addProgress")
	public String addProgress(@RequestBody Progress progress) {
		return progressService.addProgress(progress);
	}

	@PutMapping("/updateProgress")
	public String updateProgress(@RequestBody Progress progress) {
		return progressService.updateProgress(progress);
	}

	@DeleteMapping("/deleteProgress/{id}")
	public void deleteProgress(@PathVariable Long id) {
		progressService.deleteProgress(id);
	}
}

