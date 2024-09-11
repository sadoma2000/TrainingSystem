package com.Training_System.service.interfaces;

import java.util.List;

import com.Training_System.model.Progress;

public interface IProgressService {

    String addProgress(Progress progress);

    String updateProgress(Progress progress);

    void deleteProgress(Long id);

    Progress getProgressById(Long id);

    List<Progress> getAllProgress();

    List<Progress> getProgressByStudentId(Long studentId);
}


