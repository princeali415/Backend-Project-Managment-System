package com.personalprojects.projectmanagementsystem.repositories;

import com.personalprojects.projectmanagementsystem.models.Project;
import com.personalprojects.projectmanagementsystem.views.ProblemListGroupedByProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long>
{
    @Query(value = "SELECT pj.projectid as projectid, pj.projectname as projectname, pj.projectdescription as projectdescription, " +
        "p.problemname as problemname, p.problemdescription as problemdescription " +
        "FROM projects pj " +
        "JOIN problems p " +
        "ON pj.projectid = p.projectid " +
        "GROUP BY pj.projectname, p.problemname",
        nativeQuery = true)
    List<ProblemListGroupedByProject> getProblemListGroupedByProject();
}
