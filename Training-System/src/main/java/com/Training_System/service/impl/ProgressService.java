package com.Training_System.service.impl;

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
	public void saveProgress(Progress progress) {
		Progress newProgress = new Progress();
		newProgress.setStudent_id(progress.getStudent_id());
		newProgress.setCourse_id(progress.getCourse_id());
		newProgress.setCompleted_tasks(progress.getCompleted_tasks());
		newProgress.setRequired_tasks(progress.getRequired_tasks());

		progressRepository.save(newProgress);
	}

	@Override
	public void updateProgress(int completedTasks, Long id) {
		Optional<Progress> progressOptional = progressRepository.findById(id);
		if (progressOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + id + " not found");

		Progress p = progressOptional.get();
		p.setCompleted_tasks(completedTasks);
		progressRepository.save(p);
	}

	@Override
	public void deleteProgress(Long id) {
		Optional<Progress> progressOptional = progressRepository.findById(id);
		if (progressOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Progress " + id + " not found");
		progressRepository.deleteById(id);
	}
}
