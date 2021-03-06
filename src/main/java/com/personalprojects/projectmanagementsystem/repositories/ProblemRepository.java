package com.personalprojects.projectmanagementsystem.repositories;

import com.personalprojects.projectmanagementsystem.models.Problem;
import com.personalprojects.projectmanagementsystem.views.ProblemList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemRepository extends CrudRepository<Problem, Long>
{
    @Query(value = "SELECT p.problemid, pj.projectname, p.problemname, p.problemdescription, u.username as assignedto, " +
        "u.email as assignedtoemail, pt.problemtype, s.status as status " +
        "FROM problems p " +
        "JOIN users u ON p.userid=u.userid " +
        "JOIN statustypes s ON p.statustypeid=s.statustypeid " +
        "JOIN projects pj ON p.statustypeid=pj.projectid " +
        "JOIN problemtypes pt ON p.problemtypeid=pt.problemtypeid",
        nativeQuery = true)
    List<ProblemList> getAllProblemsJoinedList();
}
