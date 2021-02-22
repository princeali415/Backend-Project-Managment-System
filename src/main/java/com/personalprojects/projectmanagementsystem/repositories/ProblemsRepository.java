package com.personalprojects.projectmanagementsystem.repositories;

import com.personalprojects.projectmanagementsystem.models.Problem;
import org.springframework.data.repository.CrudRepository;

public interface ProblemsRepository extends CrudRepository<Problem, Long>
{
}
