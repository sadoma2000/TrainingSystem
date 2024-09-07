package com.Training_System.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Training_System.model.Progress;
import com.Training_System.repository.ProgressRepository;
import com.Training_System.service.interfaces.IProgressService;

@Service
public class ProgressService implements IProgressService {

	@Autowired
	ProgressRepository progressRepository;

	@Override
	public Progress getProgressById(Long id) {
		return progressRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + id + " not found"));
	}

	@Override
	public List<Progress> getAllProgress() {
		return progressRepository.findAll();
	}

	@Override
	public List<Progress> getProgressByStudentId(Long studentId) {
		return progressRepository.findByStudentId(studentId);
	}

	@Override
	public String addProgress(Progress progress) {
		Progress newProgress = new Progress();
		newProgress.setStudent_id(progress.getStudent_id());
		newProgress.setCourse_id(progress.getCourse_id());
		newProgress.setCompleted_tasks(progress.getCompleted_tasks());
		newProgress.setRequired_tasks(progress.getRequired_tasks());

		progressRepository.save(newProgress);
		return "Progress added successfully";
	}

	@Override
	public String updateProgress(Progress progress) {
		Optional<Progress> progressOptional = progressRepository.findById(progress.getId());
		if (progressOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + progress.getId() + " not found");

		Progress existingProgress = progressOptional.get();
		existingProgress.setCompleted_tasks(progress.getCompleted_tasks());
		existingProgress.setRequired_tasks(progress.getRequired_tasks());

		progressRepository.save(existingProgress);
		return "Progress updated successfully";
	}

	@Override
	public void deleteProgress(Long id) {
		Optional<Progress> progressOptional = progressRepository.findById(id);
		if (progressOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + id + " not found");

		progressRepository.deleteById(id);
	}


}