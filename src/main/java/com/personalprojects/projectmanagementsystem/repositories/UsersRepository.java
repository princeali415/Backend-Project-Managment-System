package com.personalprojects.projectmanagementsystem.repositories;

import com.personalprojects.projectmanagementsystem.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>
{
}
