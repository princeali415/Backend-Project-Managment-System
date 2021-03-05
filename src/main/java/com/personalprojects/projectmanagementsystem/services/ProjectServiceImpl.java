package com.personalprojects.projectmanagementsystem.services;

import com.personalprojects.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.personalprojects.projectmanagementsystem.models.Project;
import com.personalprojects.projectmanagementsystem.repositories.ProjectRepository;
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
}
