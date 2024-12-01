/*main tables*/
create table patient(
PID char(9) not null,
ssn numeric(9) not null,
fname varchar(10) not null,
minitial char(1),
lname varchar(10) not null,
sex varchar(10) not null,
birthdate date not null,
condit varchar(10) not null check (condit in ('Critical', 'Stable', 'Fair')),
curraddress varchar(50),  
currphone numeric(10),
permaddress varchar(50) not null,
permcity varchar(20),
permstate char(2),
permzipp numeric(5),
permphone numeric(10),
doctorID char(9),
primary key(PID),
unique (ssn)
);

create table doctor(
DID char(9) not null,
ssn numeric(9) not null,
fname varchar(10) not null,
minitial char(1),
lname varchar(10) not null,
address varchar(50)not null,
phonenumber numeric(10) not null,
birthdate date not null,
dcode char(4) DEFAULT '0000',
primary key (DID),
unique (ssn)
);

create table department(
dname varchar(15) not null,
dcode char(4) not null,
dnumber numeric(4) not null,
dphone numeric(9) not null,
dheadID char(9) default 'D00000000',
primary key (dcode),
unique (dname)
);

create table medication(
mname varchar(20) not null,
mdescription varchar(50) not null,
manufacturer varchar(20) not null,
primary key (mname)
);

create table operation(/*procedure was a keyword renamed to operation*/
pnumber char(7) not null,
pname varchar(10) not null,
pdescription varchar(100) not null,
pduration int, /*Figure out how to determine duration*/
offerdep char(4) not null,
primary key (pnumber)
);

/*alter tables adding constraints*/
alter table patient add CONSTRAINT PatFK
foreign key (doctorID) references doctor(DID)
ON DELETE SET NULL;

alter table doctor add CONSTRAINT DocFK
foreign key (dcode) references department(dcode) 
ON DELETE SET NULL;

alter table department add constraint DeptFK
foreign key (dheadID) references doctor(DID)
ON DELETE SET NULL;

alter table operation add CONSTRAINT OperFK
foreign key (offerdep) references department(dcode);

/*supporting/relationship tables*/
create table interactionRecord(
IID int not null,
idate date not null,
description varchar(100) not null,
patientID char(9) not null,
primary key (IID,patientID),
foreign key (patientID) references patient(PID)
);

/*this could possibly removed by adding an extra attribute in patient
and making a combination primary key but it could cause duplicate/incorrect info 
in patient if being edited
*/
create table secondarydoctor(
patientID char(9) not null,
doctorID char(9) not null,
primary key (patientID,doctorID),
foreign key (patientID) references patient(PID),
foreign key (doctorID) references doctor(DID)
);

create table prescription(
patientID char(9) not null,
doctorID char(9) not null,
datePrescribed date not null,
mname varchar(20) not null,
primary key (patientId, mname),
foreign key (patientID) references patient(PID),
foreign key (doctorID) references doctor(DID),
foreign key (mname) references medication(mname)
);

create table undergo(
patientID char(9) not null,
doctorID char(9) not null,
datePerformed date not null,
notes varchar(100),
pnumber char(7) not null,
primary key (patientID, pnumber, doctorID), /*due to this primary key set up it means that you are able to insert multiple doctors for the same operaction*/
foreign key (patientID) references patient(PID),
foreign key (doctorID) references doctor(DID),
foreign key (pnumber) references operation(pnumber)
);

/*Front End Notes:
To fullfil the requirement that some applications need a seperate city/state/zip
You parse it out in the front end

For multiple doctors front end needs to ask if there are multiple doctors
Then it will need to insert the same undergo information with a different doctor id

We can try to create a way to allow insertion of either the name of the department
or the department code

will need to create a function when they insert into prescription
or undergo to create an interaction record
*/
