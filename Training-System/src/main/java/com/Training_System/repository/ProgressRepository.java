package com.Training_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Training_System.model.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

	List<Progress> findByStudentId(Long studentId);

}
