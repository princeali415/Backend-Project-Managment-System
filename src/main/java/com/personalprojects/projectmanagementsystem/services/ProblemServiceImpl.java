package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.personalprojects.projectmanagementsystem.models.Problem;
import com.personalprojects.projectmanagementsystem.models.ProblemType;
import com.personalprojects.projectmanagementsystem.repositories.ProblemRepository;
import com.personalprojects.projectmanagementsystem.views.ProblemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
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

    @Autowired
    private HelperFunctions helperFunctions;

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

    @Transactional
    @Override
    public Problem save(Problem problem)
    {
        Problem newProblem = new Problem();

        if (problem.getProblemid() != 0)
        {
            problemRepository.findById(problem.getProblemid())
                .orElseThrow(() -> new ResourceNotFoundException("Problem Id + " + problem.getProblemid() + " not found!"));
            newProblem.setProblemid(problem.getProblemid());
        }


        newProblem.setProblemname(problem.getProblemname());
        newProblem.setProblemdescription(problem.getProblemdescription());
        newProblem.setProblemtype(problem.getProblemtype());
        newProblem.setProject(problem.getProject());
        newProblem.setUser(problem.getUser());
        newProblem.setStatus(problem.getStatus());

        return problemRepository.save(newProblem);
    }

    @Transactional
    @Override
    public Problem update(Problem problem, long id)
    {
        Problem currentProblem = findProblemById(id);

        if (helperFunctions.isAuthorizedToMakeChange(currentProblem.getProblemname()))
        {
            if (problem.getProblemname() != null)
            {
                currentProblem.setProblemname(problem.getProblemname());
            }
            if (problem.getProblemdescription() != null)
            {
                currentProblem.setProblemdescription(problem.getProblemdescription());
            }
            if (problem.getProblemtype() != null)
            {
                currentProblem.setProblemtype(problem.getProblemtype());
            }
            if (problem.getProject() != null)
            {
                currentProblem.setProject(problem.getProject());
            }
            if (problem.getUser() != null)
            {
                currentProblem.setUser(problem.getUser());
            }
            if (problem.getStatus() != null)
            {
                currentProblem.setStatus(problem.getStatus());
            }
            return problemRepository.save(currentProblem);
        } else
        {
            // note we should never get to this line but is needed for the compiler
            // to recognize that this exception can be thrown
            throw new OAuth2AccessDeniedException();
        }
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        problemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Problem ID " + id + " not found!"));
        problemRepository.deleteById(id);
    }
}
