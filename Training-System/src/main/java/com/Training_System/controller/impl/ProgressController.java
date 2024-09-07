package com.Training_System.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Training_System.model.Lesson;
import com.Training_System.service.interfaces.LessonService;

import java.util.List;

@RestController
public class Progress Controller{

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

