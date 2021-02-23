package com.personalprojects.projectmanagementsystem.controllers;

import com.personalprojects.projectmanagementsystem.models.Problem;
import com.personalprojects.projectmanagementsystem.services.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problems")
public class ProblemController
{
    @Autowired
    public ProblemService problemService;

    // GET REQUESTS

    // get all problems
    //http://localhost:2019/problems/problems  // Not working same 500 error ask john or jamie
    @GetMapping(value = "/problems", produces = "application/json")
    public ResponseEntity<?> listAllProblems()
    {
        List<Problem> problemList = problemService.findAllProblems();
        return new ResponseEntity<>(problemList, HttpStatus.OK);
    }

    // get  problem by problemid
    //http://localhost:2019/problems/problem/{problemid}  // Not working same 500 error ask john or jamie
    @GetMapping(value = "/problem/{problemid}", produces = "application/json")
    public ResponseEntity<?> findProblemById(@PathVariable long problemid)
    {
        Problem problem = problemService.findProblemById(problemid);
        return new ResponseEntity<>(problem, HttpStatus.OK);
    }
}
