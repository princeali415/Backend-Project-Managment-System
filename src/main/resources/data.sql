DELETE
FROM problems;

DELETE
FROM projects;

DELETE
FROM users;

DELETE
FROM statustypes;

DELETE
FROM problemtypes;

DELETE
FROM roletypes;

INSERT INTO roletypes (roletypeid, roletype)
VALUES (1, 'Project Manager'),
       (2, 'Developer');

INSERT INTO problemtypes (problemtypeid, problemtype)
VALUES (1, 'Bug'),
       (2, 'Task');

INSERT INTO statustypes (statustypeid, status)
VALUES (1, 'Open Ticket'),
       (2, 'Assigned to Developer'),
       (3, 'In Progress'),
       (4, 'Testing'),
       (5, 'Completed');

INSERT INTO users (userid, username, roletypeid, email, password, createdby, createddate, lastmodifiedby,
                   lastmodifieddate)
VALUES (1, 'Hussain Ali', 1, 'hussain@gmail.com', 'password', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM',
        CURRENT_TIMESTAMP),
       (2, 'Ruben Ramirez', 2, 'ruben@gmail.com', 'password', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM',
        CURRENT_TIMESTAMP),
       (3, 'Chandler Roselli', 2, 'chandler@gmail.com', 'codingiscool', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM',
        CURRENT_TIMESTAMP);

INSERT INTO projects (projectid, projectname, projectdescription, createdby, createddate, lastmodifiedby,
                      lastmodifieddate)
VALUES (1, '8-up Project Management System', 'lean pms for developers', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM',
        CURRENT_TIMESTAMP),
       (2, 'Anywhere-Fitness', 'online fitness class', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
       (3, 'Co-Make', 'community forum', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO problems (problemid, problemname, problemdescription, problemtypeid, projectid, userid, statustypeid,
                      createdby, createddate, lastmodifiedby, lastmodifieddate)
VALUES (1, 'fix kanban component', 'kanban component wont drag n drop', 1, 1, 1, 1, 'SYSTEM', CURRENT_TIMESTAMP,
        'SYSTEM', CURRENT_TIMESTAMP),
       (2, 'style error home page', 'section has border take it off', 1, 1, 1, 1, 'SYSTEM', CURRENT_TIMESTAMP,
        'SYSTEM', CURRENT_TIMESTAMP);

/*
We must tell hibernate the ids that have already been used.
The number must be larger than the last used id.
20 > 5 so we are good!
 */

alter sequence hibernate_sequence restart with 20;