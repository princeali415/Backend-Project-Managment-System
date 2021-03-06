package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.Problem;
import com.personalprojects.projectmanagementsystem.views.ProblemList;

import java.util.List;

public interface ProblemService
{

    public List<Problem> findAllProblems(); // get all problems

    Problem findProblemById(long problemid); // get problem by id

    List<ProblemList> findAllProblemsJoinedList();  // custom view of problem list
}
