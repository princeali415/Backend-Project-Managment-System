# Backend-Project-Managment-System

## Introduction

This is a basic database scheme with users, problems(tickets), projects, role_types, problem_types, and status types. 
This Java Spring REST API application willprovide the data modeling to support the project management system 8-up.

### Database layout

The table layouts are as follows:

![Image of Database Layout](3NFPMS.png)

* USERS
    * USER_ID Primary key, not null Long
    * USERNAME String
    * ROLE_TYPE_ID Long foreign key (many users to one role type)
    * EMAIL String
    * PASSWORD String
    * CREATED_BY String
    * CREATED_DATE Timestamp
    * LAST_MODIFIED_BY String
    * LAST_MODIFIED_DATE Timestamp

* PROBLEMS
    * PROBLEM_ID primary key, not null Long
    * PROBLEM_NAME String, not null
    * PROBLEM_DESCRIPTION String
    * PROBLEM_TYPE_ID Long foreign key(many problems to one problem type)
    * PROJECT_ID Long foreign key(many problems to one project)
    * PROJECT_MANAGER_ID Long foreign key(many problems to one project manager)
    * DEVELOPER_ID Long foreign key(many problems to one developer)
    * STATUS_TYPE_ID Long foreign key(many problems to one status type)
    * CREATED_BY String
    * CREATED_DATE Timestamp
    * LAST_MODIFIED_BY String
    * LAST_MODIFIED_DATE Timestamp

* PROJECTS
    * PROJECT_ID primary key, not null Long (one project to many problems)
    * PROJECT_NAME double
    * PROJECT_DESCRIPTION double
    * CREATED_BY String
    * CREATED_DATE Timestamp
    * LAST_MODIFIED_BY String
    * LAST_MODIFIED_DATE Timestamp

* ROLE_TYPES
    * ROLE_TYPE_ID primary key, not null Long (one role type to many problems)
    * ROLE_TYPE String (either developer or project manager)

* PROBLEM_TYPES
    * PROBLEM_TYPE_ID primary key, not null Long (one problem type to many problems)
    * PROBLEM_TYPE String (either bug or task)

* STATUS_TYPES
    * STATUS_TYPE_ID primary key, not null Long (one status type to many problems)
    * STATUS_TYPE String (1.Open ticket 2.Assigned to dev 3.In progres 4.Testing 5.Complete )