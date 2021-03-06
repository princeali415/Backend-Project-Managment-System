package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.personalprojects.projectmanagementsystem.models.Problem;
import com.personalprojects.projectmanagementsystem.models.Project;
import com.personalprojects.projectmanagementsystem.repositories.ProblemRepository;
import com.personalprojects.projectmanagementsystem.repositories.ProjectRepository;
import com.personalprojects.projectmanagementsystem.views.ProblemListGroupedByProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "projectService")
public class ProjectServiceImpl implements ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private ProblemService problemService;

    @Override
    public List<Project> findAllProjects()
    {
        List<Project> projectList = new ArrayList<>();
        projectRepository.findAll().iterator().forEachRemaining(projectList::add);

        return projectList;
    }

    @Override
    public Project findProjectById(long id)
    {
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project id " + id + " not found!"));

        return project;
    }

    @Override
    public List<ProblemListGroupedByProject> findAllProjectsWithProblemName()
    {
        List<ProblemListGroupedByProject> projectList = projectRepository.getProblemListGroupedByProject();
        return projectList;
    }

    @Transactional
    @Override
    public Project save(Project project)
    {
        Project newProject = new Project();

        if (project.getProjectid() != 0)
        {
            projectRepository.findById(project.getProjectid())
                .orElseThrow(() -> new ResourceNotFoundException("Project ID " + project.getProjectid() + " not found!"));
            newProject.setProjectid(project.getProjectid());
        }

        newProject.setProjectname(project.getProjectname());
        newProject.setProjectdescription(project.getProjectdescription());
        newProject.setProblems(project.getProblems());

//        newProject.getProblems().clear();
//        for (Problem p : project.getProblems())
//        {
//            Problem addProblem = problemService.findProblemById(p.getProblemid());
//
//            newProject.getProblems().add(new Problem(newProject, addProblem));
//
////            Problem addProblem = problemRepository.findById(p.getProblemid())
////                .orElseThrow(() -> new ResourceNotFoundException("Problem Id " + p.getProblemid() + " not found!"));
////            newProject.getProblems().add(new Problem(addProblem, newProject));
//        }

        return projectRepository.save(newProject);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        projectRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project ID " + id + " not found!"));
        projectRepository.deleteById(id);
    }
}
