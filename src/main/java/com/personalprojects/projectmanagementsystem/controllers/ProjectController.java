package com.personalprojects.projectmanagementsystem.controllers;

import com.personalprojects.projectmanagementsystem.models.Project;
import com.personalprojects.projectmanagementsystem.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController
{
    @Autowired
    private ProjectService projectService;

    /**
     * Returns a list of all users
     * <br>Example: <a href="http://localhost:2019/users/users">http://localhost:2019/users/users</a>
     *
     * @return JSON list of all users with a status of OK
     * @see ProjectService#findAll() UserService.findAll()
     */
    //http://localhost:2019/projects/projects
    @GetMapping(value = "/projects", produces = {"application/json"})
    public ResponseEntity<?> listAllProjects()
    {
        List<Project> projectList = projectService.findAllProjects();
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }
}
