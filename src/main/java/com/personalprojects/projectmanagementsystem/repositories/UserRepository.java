package com.personalprojects.projectmanagementsystem.repositories;

import com.personalprojects.projectmanagementsystem.models.User;
import com.personalprojects.projectmanagementsystem.views.ProblemCountByUsername;
import com.personalprojects.projectmanagementsystem.views.ProblemListByUsername;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>
{
    /**
     * Find a user based off over username
     *
     * @param username the name (String) of user you seek
     * @return the first user object with the name you seek
     */
    User findByUsername(String username);

    /**
     * Find total problem count by username
     */
    @Query(value = "SELECT u.username as username, u.userid as userid, count(p.userid) as problemcount " +
        "FROM users u JOIN problems p ON u.userid = p.userid  " +
        "GROUP BY u.username  " +
        "ORDER BY u.userid",
        nativeQuery = true)
    List<ProblemCountByUsername> getProblemCountByUsername();

    /**
     * Find list of problems by username
     */
    @Query(value = "SELECT u.username as username, u.userid as userid, p.problemname as problemname, " +
        "p.problemdescription as problemdescription, p.problemid as problemid, p.projectid as projectid," +
        " p.statustypeid as statustype, p.problemtypeid as problemtype " +
        "FROM users u JOIN problems p ON u.userid = p.userid " +
        "GROUP BY u.username, p.problemname " +
        "ORDER BY u.userid",
        nativeQuery = true)
    List<ProblemListByUsername> getProblemListByUsername();


}
