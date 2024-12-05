# How to set up:
In Oracle SQL Developer

Run CreateTable to create DB
Run InsertTest to insert text value examples in DB

Run DropTable to clear everything

src folder in Eclipse IDE
With Oracle Database driver ojdbc1.jar in build path as an external library

Run P1 for terminal use

Run MainGUI for limited GUI use

# Project Contributions
Our project involved a collaborative effort where each of us contributed equally to the completion of key deliverables.
1. Ben Draper – Relational Database Schema Design & Frontend Terminal
* Ben was responsible for designing the relational database schema for the project.
Frontend:
* Created the basic interaction interface for the back end design
* Display menu options in the menu and asks for user for the appropriate information based on the option selected
* Implement SQL commands to be executed in the interface
* Provided needed changes for backend

2. Aryasomayajula Aditya – ER Diagram Design & GUI Design
* Aditya led the design of the Entity-Relationship (ER) Diagram for the project.
GUI:
* Created the layout for the GUI
* Implemented the basic interaction interface functions to work in the GUI

3. Kian Aliwalas – Finalization/Editing & Backend design
* Kian took on the responsibility of finalizing and refining both the relational database schema and the ER Diagram.
Backend:
* Designed the table layout for the backend database
* Created script to build/drop the database table
* Created Insert script to demonstrate inserting data into the database
* Provided guidance on features and functions required

# Project Description
Introduction
Please read this document carefully in its entirety before starting your work.

The purpose of this project is to provide you with hands-on experience in the design, creation, development, and maintenance of a relational database. This project provides a realistic experience to apply the knowledge and skills you learn in class. The project will be completed in two phases where the first phase focuses on the design of a database system and the second phase focuses on its implementation. You will be completing this project in a group (2-3 members per group) and you will work in the same group for the entire project. But, note you may get a different score than your group depending on your contributions to the project. 

## Requirements
Develop a database (back-end) and a software application (front-end) for managing data in a hospital as described below:

The hospital keeps track of each patient's name (first name, middle initial, and last name), patient ID (letter "P" followed by 8 digits), social security number (digit number in the format "AAA-GG-SSSS"), current address and phone, permanent address and phone (XXX-XXX-XXXX), birthdate (format MM-DD-YYYY), sex (male, female or user-provided), patient condition (Critical, Stable or Fair ), primary care doctor, secondary care doctor (if any), and the procedures they undergo (regular visit, surgery, MRI, x-ray, etc). Some user applications need to refer to the city, state, and zip of the patient's permanent address, and to the patient's last name. Both social security numbers and patient ID have unique values for each patient.
The hospital has departments and each department is described by a name (Family medicine, Cardiology, etc.), department code (up to 4 characters), office number (4 digits), office phone, and a department head who is a doctor. Both the name of the department and the code have unique values for each department.
Each procedure has a  procedure name, description, procedure number (3 letters followed by 4 digits), duration, and an offering department. The value of the procedure number is unique for each procedure.
A doctor is associated with a department and has a unique social security number and a unique Doctor ID (letter "D" followed by 8 digits). The hospital requires keeping track of a Doctor's name (First, middle initial, and last name), address, phone number, birth date, and contact number. 
When the patient interacts with the hospital in some way (taking a procedure/procedures, calling to ask a question) it creates an interaction record. Each interaction record has an interaction ID, a date and a time, and a description of an interaction. The interaction ID distinguishes interaction records of the same patient; its values are 1, 2, 3, ..., up to the number of such interactions.
When a patient undergoes a procedure it needs to keep track of the doctor/s who were involved in the procedure and the date and time it took place, and any notes. 
It also needs to keep track of the medications prescribed to the patient, with the doctor who prescribed them (not necessarily the primary or secondary care doctors), and the date that they were prescribed. Each medication has a unique name, a manufacturer, and a description.
Users should be able to perform the following tasks using the front-end:

Add a patient, department, procedures, doctors, medication, and interaction records.
Add information about a procedure done on a patient.
Add medication/s prescribed to a patient.
Given a patient ID, generate their complete health record. The health record should include patient information (name, current address and current phone, primary doctor), (a) all the procedures they had, (b) all the interactions they had with the hospital (with dates and the details), and (c) all the medications prescribed to them (with dates and details).
Given a department name or code find the procedures offered. 
Given a doctor's ID list all the procedures they have done.
Technologies
Backend - Relational database using Oracle (or another DBMS with my permission) - We have set up an Oracle server for the class and you will be provided with the login information before you start part 2 of the project.  
Front-end interactive interface using Java (or another language with my permission). The front-end can be a command-line interface or a graphical user interface (GUI). Extra credit will be given to developing a GUI.

# Part 1 - ER Diagram and Relational Schema (check Canvas for the due date)
Draw an ER or EER, diagram for your database design (use Chapters 3 and 4 as your guide) Then convert your ER (or EER) diagram into a relational database schema diagram (use Chapters 5 and 9  as your guide).  You may use any software tool of your choice to develop diagrams, but handwritten diagrams will not be accepted.

Guidelines for creating ER/EER diagram
Make sure to indicate:
keys,
all attributes,
composite attributes (if any),
meaningful derived attributes (if any),
relationship attributes (if any),
weak entities (if any),
cardinality constraints, and
participation constraints.
Hint: Consider twelve common ER diagram mistakes listed in this articleLinks to an external site. and make sure you don't repeat them. 
If there are extra constraints that cannot be captured by the ER diagram, make sure you list them in the supplementary text.
List any assumptions you make in the process.
Guidelines for creating relational database schema diagram
Your relational database schema diagram should be similar in style to Figure 9.2 (p.291) in the textbook. Do not overcomplicate the task by using other diagram types (e.g, UML).
Transform the conceptual data into relations:
Represent entities
Map multivalued attributes
Map weak entity types
Map all relationship types
binary 1:1
binary 1:N
binary M:N
n-ary relationships
Ensure well-formed relations:
the minimum amount of redundancy
permits users to insert, modify and delete the rows without errors or inconsistencies
Identify all primary keys:
value of the key must uniquely identify every row in the relation
keys should be nonredundant
Ensure referential integrity is achieved (i.e., no dangling references)
Deliverables (worth 40% of project points)
Submit a pdf document that contains your (1) ER/ERR diagram and (2) relational database schema. 
Text document detailing the contributions of each team member towards the deliverables.
 

# Part 2 - Database System Implementation (check Canvas for the due date)
Normalize the relations developed in Part 1 if applicable and update the related diagrams developed in Part 1 accordingly.
Implement the back-end: Implement necessary tables based on your normalized relational schema. For each table created, you should include:
name (be descriptive) of each attribute
type of each attribute (consider the storage space implications of each choice)
attribute constraints (e.g.,NOT NULL, uniqueness, default value)
primary key
foreign keys (all of them)
referential integrity constraints
CHECK clauses (if needed)
short comment linking the table creation command to the entity name of your ER diagram (use -- character to comment)
Implement the front-end that can perform the tasks described above under requirements and interact with the back-end. The front-end can be a command-line interface or a graphical user interface (GUI). Extra credit will be given to developing a GUI. 
The database system should be easy to navigate and use.
Deliverables (worth 60% of project grade)
Source code of the database system. 
Updated ER/EER diagrams and relational schemas.
10-minute demonstration during class-time (scheduled during the final two weeks of the classes).

