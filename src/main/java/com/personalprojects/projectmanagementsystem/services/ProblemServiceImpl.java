package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.models.Problem;
import com.personalprojects.projectmanagementsystem.repositories.ProblemRepository;
import com.personalprojects.projectmanagementsystem.views.ProblemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "problemService")
public class ProblemServiceImpl implements ProblemService
{
    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public List<Problem> findAllProblems()
    {
        List<Problem> problemList = new ArrayList<>();
        problemRepository.findAll().iterator().forEachRemaining(problemList::add);

        return problemList;
    }

    @Override
    public List<ProblemList> findAllProblemsJoinedList()
    {
        List<ProblemList> problemList = problemRepository.getAllProblemsJoinedList();
        return problemList;
    }

    @Override
    public Problem findProblemById(long problemid)
    {
        Problem problem = problemRepository.findById(problemid)
            .orElseThrow(() -> new EntityNotFoundException("Problem " + problemid + "Not Found"));

        return problem;
    }
}
