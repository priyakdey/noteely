# noteely

**noteely** is a note-taking and sharing application. **noteely** makes it
easy to take notes during a class, lecture or meeting and sharing them with
peers.

## Table of Content

- [Description](#description)
- [Setup](#setup)
- [Problem Statement](#problem-statement)
  - [Technical Requirements](#technical-requirements)
  - [Deliverables](#deliverables)
  - [Evaluation Criteria](#evaluation-criteria)
  - [Tech Stack Used](#tech-stack-used)
    - [Reasons for choice of tech stack](#reasons-for-choice-of-tech-stack)
- [Project Board](#project-board)
- [LICENSE](#license)

## Description

**notely** is a note taking and sharing application. This application for not
production grade and backend only (for now). This project is a child of the
technical assessment challenge by [speer.io](https://speer.io/) for Backend
Role. More details can be found here:
[Link to challenge](https://miro.com/app/board/uXjVMJK4wq0=/)

## Setup

_Yet to be updated_

## Problem Statement

You have been asked to build a secure and scalable RESTful API that allows users
to create, read, update, and delete notes. The application should also allow
users to share their notes with other users and search for notes based on
keywords.

### Technical Requirements

1. Implement a RESTful API using a framework of your choice (e.g. Express, DRF,
   Spring).
2. Use a database of your choice to store the data (preferably MongoDB or
   PostgreSQL).
3. Use any authentication protocol and implement a simple rate limiting and
   request throttling to handle high traffic.
4. Implement search functionality to enable users to search for notes based on
   keywords. ( preferably text indexing for high performance )
5. Write unit tests and integration tests your API endpoints using a testing
   framework of your choice.

Your API should implement the following endpoints:

- Authentication Endpoints
  - `POST /api/auth/signup`: create a new user account.
  - `POST /api/auth/login`: log in to an existing user account and receive an
    access token.
- Note Endpoints
  - `GET /api/notes`: get a list of all notes for the authenticated user.
  - `GET /api/notes/:id`: get a note by ID for the authenticated user.
  - `POST /api/notes`: create a new note for the authenticated user.
  - `PUT /api/notes/:id`: update an existing note by ID for the authenticated
    user.
  - `DELETE /api/notes/:id`: delete a note by ID for the authenticated user.
  - `POST /api/notes/:id/share`: share a note with another user for the
    authenticated user.
  - `GET /api/search?q=:query`: search for notes based on keywords for the
    authenticated user.

### Deliverables

1. A GitHub repository with your code.
2. A README file
3. Details explaining the choice of framework/db/ any 3rd party tools.
4. instructions on how to run your code and run the tests.
5. Any necessary setup files or scripts to run your code locally or in a test
   environment.

### Evaluation Criteria

Your code will be evaluated on the following criteria:

1. Correctness: does the code meet the requirements and work as expected?
2. Performance: does the code use rate limiting and request throttling to handle
   high traffic?
3. Security: does the code implement secure authentication and authorization
   mechanisms?
4. Quality: is the code well-organized, maintainable, and easy to understand?
5. Completeness: does the code include unit, integration, and end-to-end tests
   for all endpoints?
6. Search Functionality: does the code implement text indexing and search
   functionality to enable users to search for notes based on keywords?

### Tech Stack Used

- Java (21)
- Spring/SpringBoot (3.x)
- Test Containers (for integration testing)
- MongoDB

##### Reasons for choice of tech stack

1. I like my type system to complain before application runs in production, so
   choice is either Java or Go.
2. More familiar with Java and its ecosystem, so the choice of Java.
3. SpringBoot - cause its the go to web framework for Java web development, and
   I am more familiar with this
4. MongoDB - Reason is two fold: Mongo supports Text Indexing for faster
   searches, which will help in the requirement and horizontally scalable.
   Secondly, never uses a nosql DB, so a good chance to learn.
5. Test Container - Docker is the best thing till now, and test containers just
   makes it easy to work with integration test, also run multiple TCs parallely
   with multiple containers.
6. username/password storing is the last thing to do in this era, we should rely
   on providers. For sake of this problem, we are giving an option for custom
   email/password signin.

## Project Board

[Link](https://github.com/users/priyakdey/projects/17)

## LICENSE

All source code is released under MIT LICENSE, a copy of which can be found
[here](LICENSE).
