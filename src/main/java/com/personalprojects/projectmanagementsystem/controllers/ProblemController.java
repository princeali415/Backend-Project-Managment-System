package com.personalprojects.projectmanagementsystem.controllers;

import com.personalprojects.projectmanagementsystem.models.Problem;
import com.personalprojects.projectmanagementsystem.services.ProblemService;
import com.personalprojects.projectmanagementsystem.views.ProblemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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

    // get all problems custom view joined list
    //http://localhost:2019/problems/problemsjoinedlist
    @GetMapping(value = "/problemsjoinedlist", produces = "application/json")
    public ResponseEntity<?> listAllProblemsCustom()
    {
        List<ProblemList> problemList = problemService.findAllProblemsJoinedList();

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

    //POST
    //Create new problems
    @PostMapping(value = "/problem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewProblem(@Valid @RequestBody Problem newproblem) throws URISyntaxException
    {
        newproblem = problemService.save(newproblem);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("{/problemid}")
            .buildAndExpand(newproblem.getProblemid())
            .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //PUT
    // Update problem by problem id
    @PutMapping(value = "problem/{problemid}", consumes = "application/json")
    public ResponseEntity<?> updateProblem(@Valid @RequestBody Problem updateProblem, @PathVariable long problemid)
    {
        updateProblem.setProblemid(problemid);
        problemService.save(updateProblem);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DELETE
    // Delete problem by id
    @DeleteMapping(value = "/problem/{problemid}")
    public ResponseEntity<?> deleteItemById(@PathVariable long problemid)
    {
        problemService.delete(problemid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
