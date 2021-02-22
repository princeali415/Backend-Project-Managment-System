package com.personalprojects.projectmanagementsystem.repositories;

import com.personalprojects.projectmanagementsystem.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectsRepository extends CrudRepository<Project, Long>
{
}
