create table department (
  dname char(20) not null,
  dnumber numeric(1) not null,  
  mgrssn numeric(9) not null,   
  mgrstartdate date not null, 
  primary key (dnumber), 
  unique (dname)
);
create table employee (
  fname char(10) not null,
  lname char(20) not null,
  ssn numeric(9) not null,  
  bdate date not null,
  address char(30) not null,
  sex char(1) not null,
  salary numeric(5) not null,
  superssn numeric(9),
  dno numeric(1) not null, 
  primary key (ssn), 
  foreign key (dno) references department(dnumber)
); 
create table project (
  pname char(20) not null,
  pnumber numeric(2) not null,  
  plocation char(20) not null,
  dnum numeric(1) not null, 
  primary key (pnumber), 
  unique (pname), 
  foreign key (dnum) references department(dnumber)
); 
create table works_on (
  essn numeric(9) not null,  
  pno numeric(2) not null, 
  hours numeric(5,1),  
  primary key (essn, pno), 
  foreign key (essn) references employee(ssn),
  foreign key (pno) references project(pnumber)
); 
create table dependent (
  essn numeric(9) not null,  
  dependent_name char(10) not null,
  sex char(1) not null,
  bdate date not null,
  relationship char(30) not null,
  primary key (essn, dependent_name),
  foreign key (essn) references employee(ssn)
); 
create table dept_locations (
  dnumber numeric(1) not null,
  dlocation char (15) not null,
  primary key (dnumber, dlocation), 
  foreign key (dnumber) references department(dnumber)
);
insert into department values ('Research',5,333445555,TO_DATE('1988-05-22','YYYY-MM-DD'));
insert into department values ('Administration',4,987654321,TO_DATE('1995-01-01','YYYY-MM-DD'));
insert into department values  ('Headquarters',1,888665555,TO_DATE('1981-06-19','YYYY-MM-DD'));

insert into employee values ('John','Smith',123456789,TO_DATE('1965-01-09','YYYY-MM-DD'),'731 Fondren, Houston TX','M',30000,333445555,5);
insert into employee values ('Franklin','Wong',333445555,TO_DATE('1955-12-08','YYYY-MM-DD'),'638 Voss, Houston TX','M',40000,888665555,5);
insert into employee values ('Alicia','Zelaya',999887777,TO_DATE('1968-01-19','YYYY-MM-DD'),'3321 Castle, Spring TX','F',25000,987654321,4);
insert into employee values ('Jennifer','Wallace',987654321,TO_DATE('1941-06-20','YYYY-MM-DD'),'291 Berry, Bellaire TX','F',43000,888665555,4);
insert into employee values ('Ramesh','Narayan',666884444,TO_DATE('1962-09-15','YYYY-MM-DD'),'975 Fire Oak, Humble TX','M',38000,333445555,5);
insert into employee values ('Joyce','English',453453453,TO_DATE('1972-07-31','YYYY-MM-DD'),'5631 Rice, Houston TX','F',25000,333445555,5);
insert into employee values ('Ahmad','Jabbar',987987987,TO_DATE('1969-03-29','YYYY-MM-DD'),'980 Dallas, Houston TX','M',25000,987654321,4);
insert into employee values ('James','Borg',888665555,TO_DATE('1937-11-10','YYYY-MM-DD'),'450 Stone, Houston TX','M',55000,null,1);

insert into project values ('ProductX',1,'Bellaire',5);
insert into project values ('ProductY',2,'Sugarland',5);
insert into project values ('ProductZ',3,'Houston',5);
insert into project values ('Computerization',10,'Stafford',4);
insert into project values ('Reorganization',20,'Houston',1);
insert into project values ('Newbenefits',30,'Stafford',4);

insert into works_on values (123456789,1,32.5);
insert into works_on values  (123456789,2,7.5);
insert into works_on values  (666884444,3,40.0);
insert into works_on values  (453453453,1,20.0);
insert into works_on values  (453453453,2,20.0);
insert into works_on values  (333445555,2,10.0);
insert into works_on values  (333445555,3,10.0);
insert into works_on values  (333445555,10,10.0);
insert into works_on values  (333445555,20,10.0);
insert into works_on values  (999887777,30,30.0);
insert into works_on values  (999887777,10,10.0);
insert into works_on values  (987987987,10,35.0);
insert into works_on values  (987987987,30,5.0);
insert into works_on values  (987654321,30,20.0);
insert into works_on values  (987654321,20,15.0);
insert into works_on values  (888665555,20,null);

insert into dependent values (333445555,'Alice','F',TO_DATE('1986-04-04','YYYY-MM-DD'),'Daughter');
insert into dependent values (333445555,'Theodore','M',TO_DATE('1983-10-25','YYYY-MM-DD'),'Son');
insert into dependent values (333445555,'Joy','F',TO_DATE('1958-05-03','YYYY-MM-DD'),'Spouse');
insert into dependent values (987654321,'Abner','M',TO_DATE('1942-02-28','YYYY-MM-DD'),'Spouse');
insert into dependent values (123456789,'Michael','M',TO_DATE('1988-01-04','YYYY-MM-DD'),'Son');
insert into dependent values (123456789,'Alice','F',TO_DATE('1988-12-30','YYYY-MM-DD'),'Daughter');
insert into dependent values (123456789,'Elizabeth','F',TO_DATE('1967-05-05','YYYY-MM-DD'),'Spouse');

insert into dept_locations values (1,'Houston');
insert into dept_locations values (4,'Stafford');
insert into dept_locations values (5,'Bellaire');
insert into dept_locations values (5,'Sugarland');
insert into dept_locations values (5,'Houston');

alter table department 
 add constraint depemp foreign key (mgrssn) references employee(ssn);
alter table employee   
 add constraint empemp foreign key (superssn) references employee(ssn);