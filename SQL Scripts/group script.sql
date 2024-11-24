/*main tables*/
create table patient(
ID char(9) not null,
ssn numeric(9) not null,
fname char(10) not null,
minitial char(1),
lname char(10) not null,
sex char(10) not null,
birthdate date not null,
condit char(10) not null check (condit in ('Critical', 'Stable', 'Fair')),
curraddress varchar(50),  
currphone char(9),
permaddress varchar(50) not null,
permcity varchar(10),
permstate char(2),
permzipp numeric(5),
permphone char(9),
doctorID char(9),
primary key(ID),
unique (ssn) ,
CONSTRAINT PatFK
foreign key (doctorID) references doctor(ID)
ON DELETE SET NULL
);

create table doctor(
ID char(9) not null,
ssn numeric(9) not null,
fname varchar(10) not null,
minitial char(1),
lname varchar(10) not null,
address varchar(50)not null,
phonenumber char(9) not null,
birthdate date not null,
dcode char(4) DEFAULT '0000',
primary key (ID),
unique (ssn),
CONSTRAINT DocFK
foreign key (dcode) references department(dcode) 
ON DELETE SET NULL
);

create table department(
dname varchar(10) not null,
dcode char(4) not null,
dnumber numeric(4) not null,
dphone numeric(9) not null,
dheadID char(9) default 'D00000000',
primary key (dcode),
unique (dname),
constraint DeptFK
foreign key (dheadID) references doctor(ID)
ON DELETE SET NULL
);

create table medication(
name varchar(10) not null,
description varchar(50) not null,
manufactuer varchar(20) not null,
primary key (name)
);

create table operation(
pnumber char(7) not null,
name varchar(10) not null,
description varchar(100) not null,
offerdep char(4)not null,
primary key (pnumber),
CONSTRAINT OperFK
foreign key (offerdep) references department(dcode)
);

/*supporting/relationship tables*/
create table interactionRecord(
ID char(9) not null,
idate date not null,
description varchar(100) not null,
patientID char(9) not null,
primary key (ID),
foreign key (patientID) references patient(patientID)
);

create table secondarydoctor(
patientID char(9) not null,
doctorID char(9) not null,
primary key (patientID,doctorID),
foreign key (patientID) references patient(ID),
foreign key (doctorID) references doctor(ID)
);

create table prescription(
patientID char(9) not null,
doctorID char(9) not null,
datePrescribed date not null,
mname varchar(10) not null,
primary key (patientId, mname),
foreign key (patientID) references patient(ID),
foreign key (doctorID) references doctor(ID),
foreign key (mname) references medication(name)
);

create table undergo(
patientID char(9) not null,
doctorID char(9) not null,
datePreformed date not null,
notes varchar(100),
pnumber char(7) not null,
primary key (patientID, pnumber),
foreign key (patientID) references patient(ID),
foreign key (doctorID) references doctor(ID),
foreign key (pnum) references operation(pnumber)
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