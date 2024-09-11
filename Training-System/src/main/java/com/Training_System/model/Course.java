package com.Training_System.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private Timestamp startDate;
    private Timestamp endDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Lesson> lessonList;

    @OneToMany(mappedBy = "course")
    private List<Certificate> certificateList = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollmentList = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Progress> progressList = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Review> reviewList = new ArrayList<>();

    @Column(columnDefinition = "INT NOT NULL")
    private Integer NumberOfLessons = 0;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String courseLevel;
    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String description;
}
