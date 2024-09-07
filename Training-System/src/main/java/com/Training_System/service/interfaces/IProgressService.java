package com.Training_System.service.interfaces;

import com.Training_System.model.Progress;

public interface IProgressService {

	void saveProgress(Progress progress);

    void updateProgress(int completedTasks, Long id);

    void deleteProgress(Long id);
}
