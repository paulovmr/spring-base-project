base-project
============

Base maven project that uses JPA (Hibernate implementation), Spring Framework, Spring Security and others common dependencies (see `<ROOT_DIRECTORY>/pom.xml` for the list of all dependencies).

Tutorial
========

 Before follow this tutorial, define your new project name, and replace it in all the `<YOUR_NEW_PROJECT_NAME>` sentences.

 1. Installing the prerequisites

  * Install your favorite Eclipse distribution
  * Install Maven 3: `sudo apt-get install maven`

 2. Installing and configuring your PostgreSQL database

  * Install PostgreSQL 9.1: `sudo apt-get install postgresql`
  * Create a new user: `sudo -u postgres createuser`
   - `Enter name of role to add: <YOUR_NEW_PROJECT_NAME>`
   - `Shall the new role be a superuser? (y/n) n`
   - `Shall the new role be allowed to create databases? (y/n) n`
   - `Shall the new role be allowed to create more new roles? (y/n) n`
  * Create a new database: `sudo -u postgres createdb <YOUR_NEW_PROJECT_NAME>db`
  * Allow your new user to access and modify the new database created: `sudo -u postgres psql`
   - `postgres=# alter user <YOUR_NEW_PROJECT_NAME> with encrypted password '<YOUR_NEW_PROJECT_NAME>';`
   - `postgres=# grant all privileges on database <YOUR_NEW_PROJECT_NAME>db to <YOUR_NEW_PROJECT_NAME>;`
  * Install the PostgreSQL client: `sudo apt-get install postgresql-client`
  * To access the database: `psql -h localhost <YOUR_NEW_PROJECT_NAME>db <YOUR_NEW_PROJECT_NAME>`
   - `Password for user <YOUR_NEW_PROJECT_NAME>: <YOUR_NEW_PROJECT_NAME>`

  * Use the following commands to control the PostgreSQL server:
   - Start the service: `/etc/init.d/postgresql start`
   - Stop the service: `/etc/init.d/postgresql stop`
   - Know the status: `/etc/init.d/postgresql status`
   - Restart the service: `/etc/init.d/postgresql restart`

 3. Creating your project

  * Create a new Github repository from this one
  * Clone your new repository: `git clone git@github.com:<YOUR_GITHUB_USER>/<YOUR_NEW_PROJECT_NAME>.git`
  * Run the script `<ROOT_DIRECTORY>/setup_new_project.sh <YOUR_NEW_PROJECT_NAME>`
  * Run a `mvn clean install && mvn eclipse:clean eclipse:eclipse` on the `implementation` directory
  * Import your project into Eclipse

 4. Deploying your application

  * To start: `<ROOT_DIRECTORY>/tools/tomcat/bin/startup.sh`
  * To stop: `<ROOT_DIRECTORY>/tools/tomcat/bin/shutdown.sh`

Developer annotations
=====================
 * The only files modified in the Tomcat are:
  - `webapps/view`: just a link for the view project's target/view folder
  - `conf/context.xml`: contains the database connection configuration
  - `temp/ work/ logs/`: their content are ignored
