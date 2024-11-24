/* PROBLEM #1 */

--    This SQL DDL script was generated by Visio Enterprise (Release Date: LOCAL BUILD).

--    Driver Used : Visio Enterprise - Oracle Server Driver.
--    Document    : C:\Documents and Settings\administrator\Desktop\drawing2.
--    Time Created: February 19, 1902 7:46 PM.
--    Operation   : From Visio Generate Wizard.
--    Connected data source : No connection.
--    Connected server      : No connection.
--    Connected database    : Not applicable.



-- Create ASSIGN3 database.
/* commented out database creation since it already exists
 *
 * connect internal ;
 * startup nomount pfile=   ;
 * spool create_db_ASSIGN3 ;
 *
 * create database ASSIGN3;
 *
 * create rollback segment ASSIGN3_r0 tablespace system ;
 *
 * alter rollback segment  ASSIGN3_r0 online ;
 *
 * -- Create Oracle exception file.
 * create table exceptions ( row_id rowid, owner varchar2(30), table_name varchar2(30), constraint varchar2(30)) ;
 *
 */

-- Create new table VENDOR.
-- VENDOR : Table of VENDOR
-- 	V_CODE : V_CODE identifies VENDOR
-- 	V_NAME : V_NAME is of VENDOR
-- 	V_CONTACT : V_CONTACT is of VENDOR
-- 	V_AREACODE : V_AREACODE is of VENDOR
-- 	V_PHONE : V_PHONE is of VENDOR
-- 	V_STATE : V_STATE is of VENDOR
-- 	V_ORDER : V_ORDER is of VENDOR
create table VENDOR (
	V_CODE NUMBER(6,0) not null,
	V_NAME VARCHAR2(20) not null,
	V_CONTACT VARCHAR2(12) not null,
	V_AREACODE NUMBER(3,0) not null,
	V_PHONE CHAR(8) not null,
	V_STATE CHAR(2) not null,
	V_ORDER CHAR(1) null, constraint VENDOR_PK primary key (V_CODE) );

-- Create new table PRODUCT.
-- PRODUCT : Table of PRODUCT
-- 	P_CODE : P_CODE identifies PRODUCT
-- 	P_DESCRIPT : P_DESCRIPT is of PRODUCT
-- 	P_INDATE : P_INDATE is of PRODUCT
-- 	P_ONHAND : P_ONHAND is of PRODUCT
-- 	P_MIN : P_MIN is of PRODUCT
-- 	P_PRICE : P_PRICE is of PRODUCT
-- 	P_DISCOUNT : P_DISCOUNT is of PRODUCT
-- 	V_CODE : V_CODE is of PRODUCT
create table PRODUCT (
	P_CODE CHAR(8) not null,
	P_DESCRIPT VARCHAR2(50) not null,
	P_INDATE DATE not null,
	P_ONHAND NUMBER(4,0) not null,
	P_MIN NUMBER(4,0) not null,
	P_PRICE NUMBER(7,2),
	P_DISCOUNT NUMBER(2,2),
	V_CODE NUMBER(6,0), constraint PRODUCT_PK primary key (P_CODE) );

-- Create new table LINE.
-- LINE : Table of LINE
-- 	INV_NUMBER : INV_NUMBER partly identifies LINE
-- 	LINE_NUMBER : LINE_NUMBER identifies LINE
-- 	P_CODE : P_CODE is of LINE
-- 	LINE_UNITS : LINE_UNITS is of LINE
-- 	LINE_PRICE : LINE_PRICE is of LINE
create table LINE (
	INV_NUMBER NUMBER(5,0) not null,
	LINE_NUMBER NUMBER(2,0) not null,
	P_CODE CHAR(8),
	LINE_UNITS NUMBER(3,0),
	LINE_PRICE NUMBER(7,2), constraint LINE_PK primary key (LINE_NUMBER, INV_NUMBER) );

-- Create new table INVOICE.
-- INVOICE : Table of INVOICE
-- 	INV_NUMBER : INV_NUMBER identifies INVOICE
-- 	CUS_CODE : CUS_CODE is of INVOICE
-- 	INV_DATE : INV_DATE is of INVOICE
create table INVOICE (
	INV_NUMBER NUMBER(5,0) not null,
	CUS_CODE CHAR(10),
	INV_DATE DATE, constraint INVOICE_PK primary key (INV_NUMBER) );

-- Create new table CUSTOMER.
-- CUSTOMER : Table of CUSTOMER
-- 	CUS_CODE : CUS_CODE identifies CUSTOMER
-- 	CUS_LNAME : CUS_LNAME is of CUSTOMER
-- 	CUS_FNAME : CUS_FNAME is of CUSTOMER
-- 	CUS_INITIAL : CUS_INITIAL is of CUSTOMER
-- 	CUS_AREACODE : CUS_AREACODE is of CUSTOMER
-- 	CUS_PHONE : CUS_PHONE is of CUSTOMER
-- 	CUS_BALANCE : CUS_BALANCE is of CUSTOMER
create table CUSTOMER (
	CUS_CODE CHAR(10) not null,
	CUS_LNAME VARCHAR2(12) not null,
	CUS_FNAME VARCHAR2(10) not null,
	CUS_INITIAL CHAR(1) null,
	CUS_AREACODE NUMBER(3,0) not null,
	CUS_PHONE CHAR(8) not null,
	CUS_BALANCE NUMBER(7,2) null, constraint CUSTOMER_PK primary key (CUS_CODE) );

-- Add foreign key constraints to table PRODUCT.
alter table PRODUCT
	add constraint VENDOR_PRODUCT_FK1 foreign key (
		V_CODE)
	 references VENDOR (
		V_CODE);

-- Add foreign key constraints to table LINE.
alter table LINE
	add constraint INVOICE_LINE_FK1 foreign key (
		INV_NUMBER)
	 references INVOICE (
		INV_NUMBER);

alter table LINE
	add constraint PRODUCT_LINE_FK1 foreign key (
		P_CODE)
	 references PRODUCT (
		P_CODE);

-- Add foreign key constraints to table INVOICE.
alter table INVOICE
	add constraint CUSTOMER_INVOICE_FK1 foreign key (
		CUS_CODE)
	 references CUSTOMER (
		CUS_CODE);


-- This is the end of the Visio Enterprise generated SQL DDL script.


/* Problem #2 */

delete from VENDOR;
insert into VENDOR
values (21225,'Bryson, Inc.','Smithson',615,'223-3234','TN','Y');
insert into VENDOR
values (21226,'Superloo, Inc.','Flushing',904,'215-8995','FL','N');
insert into VENDOR
values (21231,'D\&E Supply','Singh',615,'228-3245','TN','Y');
insert into VENDOR
values (21344,'Gomez Bros.','Ortega',615,'889-2546','KY','N');
insert into VENDOR
values (22567,'Dome Supply','Smith',901,'678-1419','GA','N');
insert into VENDOR
values (23119,'Randsets Ltd.','Anderson',901,'678-3998','GA','Y');
insert into VENDOR
values (24004,'Brackman Bros.','Browning',615,'228-1410','TN','N');
insert into VENDOR
values (24288,'ORDVA, Inc.','Hakford',615,'898-1234','TN','Y');
insert into VENDOR
values (25443,'B\&K, Inc.','Smith',904,'227-0093','FL','N');
insert into VENDOR
values (25501,'Damal Supplies','Smythe',615,'890-3529','TN','N');
insert into VENDOR
values (25595,'Rubicon Sls.','Orton',904,'456-0092','FL','Y');

delete from PRODUCT;
insert into PRODUCT
values ('11QER/31','Power painter, 15 psi., 3-nozzle',to_date('03-NOV-01','DD-MON-YY'),8,5,109.99,0.00,25595);
insert into PRODUCT
values ('13-Q2/P2','7.25-in. pwr. saw blade',to_date('13-DEC-01','DD-MON-YY'),32,15,14.99,0.05,21344);
insert into PRODUCT
values ('14-Q1/L3','9.00-in. pwr. saw blade',to_date('13-NOV-01','DD-MON-YY'),18,12,17.49,0.00,21344);
insert into PRODUCT
values ('1546-QQ2','Hrd. cloth, 1/4-in., 2x50',to_date('15-JAN-02','DD-MON-YY'),15,8,39.95,0.00,23119);
insert into PRODUCT
values ('1558-QW1','Hrd. cloth, 1/2-in., 3x50',to_date('15-JAN-02','DD-MON-YY'),23,5,43.99,0.00,23119);
insert into PRODUCT
values ('2232/QTY','B\&D jigsaw, 12-in. blade',to_date('30-DEC-01','DD-MON-YY'),8,5,109.92,0.05,24288);
insert into PRODUCT
values ('2232/QWE','B\&D jigsaw, 8-in. blade',to_date('24-DEC-01','DD-MON-YY'),6,5,99.87,0.05,24288);
insert into PRODUCT
values ('2238/QPD','B\&D cordless drill, 1/2-in.',to_date('20-JAN-02','DD-MON-YY'),12,5,38.95,0.05,25595);
insert into PRODUCT
values ('23109-HB','Claw hammer',to_date('20-JAN-02','DD-MON-YY'),23,10,9.95,0.10,21225);
insert into PRODUCT
values ('23114-AA','Sledge hammer, 12 lb.',to_date('02-JAN-02','DD-MON-YY'),8,5,14.40,0.05,NULL);
insert into PRODUCT
values ('54778-2T','Rat-tail file, 1/8-in. fine',to_date('15-DEC-01','DD-MON-YY'),43,20,4.99,0.00,21344);
insert into PRODUCT
values ('89-WRE-Q','Hicut chain saw, 16 in.',to_date('07-FEB-02','DD-MON-YY'),11,5,256.99,0.05,24288);
insert into PRODUCT
values ('PVC23DRT','PVC pipe, 3.5-in., 8-ft',to_date('20-FEB-02','DD-MON-YY'),188,75,5.87,0.00, NULL);
insert into PRODUCT
values ('SM-18277','1.25-in. metal screw, 25',to_date('01-MAR-02','DD-MON-YY'),172,75,6.99,0.00,21225);
insert into PRODUCT
values ('SW-23116','2.5-in. wd. screw, 50',to_date('24-FEB-02','DD-MON-YY'),237,100,8.45,0.00,21231);
insert into PRODUCT
values ('WR3/TT3','Steel matting, 4''x8''x1/6", .5" mesh',to_date('17-JAN-02','DD-MON-YY'),18,5,119.95,0.10,25595);
select * from product;

delete from CUSTOMER;
insert into CUSTOMER
values (10010,'Ramas','Alfred','A',615,'844-2573',0.00);
insert into CUSTOMER
values (10011,'Dunne','Leona','K',713,'894-1238',0.00);
insert into CUSTOMER
values (10012,'Smith','Kathy','W',615,'894-2285',345.86);
insert into CUSTOMER
values (10013,'Olowski','Paul','F',615,'894-2180',536.75);
insert into CUSTOMER
values (10014,'Orlando','Myron',NULL,615,'222-1672',0.00);
insert into CUSTOMER
values (10015,'O''Brian','Amy','B',713,'442-3381',0.00);
insert into CUSTOMER
values (10016,'Brown','James','G',615,'297-1228',221.19);
insert into CUSTOMER
values (10017,'Williams','George',NULL,615,'290-2556',768.93);
insert into CUSTOMER
values (10018,'Farriss','Anne','G',713,'382-7185',216.55);
insert into CUSTOMER
values (10019,'Smith','Olette','K',615,'297-3809',0.00);

delete from INVOICE;
insert into INVOICE
values (1001,10014,to_date('18-AUG-99','DD-MON-YY'));
insert into INVOICE
values (1002,10011,to_date('18-AUG-99','DD-MON-YY'));
insert into INVOICE
values (1003,10012,to_date('18-AUG-99','DD-MON-YY'));
insert into INVOICE
values (1004,10011,to_date('19-AUG-99','DD-MON-YY'));
insert into INVOICE
values (1005,10018,to_date('19-AUG-99','DD-MON-YY'));
insert into INVOICE
values (1006,10014,to_date('19-AUG-99','DD-MON-YY'));
insert into INVOICE
values (1007,10015,to_date('19-AUG-99','DD-MON-YY'));
insert into INVOICE
values (1008,10011,to_date('19-AUG-99','DD-MON-YY'));

delete from LINE;
insert into LINE
values (1001,1,'13-Q2/P2',1,14.99);
insert into LINE
values (1001,2,'23109-HB',1,9.95);
insert into LINE
values (1002,1,'54778-2T',2,4.99);
insert into LINE
values (1003,1,'2238/QPD',1,38.95);
insert into LINE
values (1003,2,'1546-QQ2',1,39.95);
insert into LINE
values (1003,3,'13-Q2/P2',5,14.99);
insert into LINE
values (1004,1,'54778-2T',3,4.99);
insert into LINE
values (1004,2,'23109-HB',2,9.95);
insert into LINE
values (1005,1,'PVC23DRT',12,5.87);
insert into LINE
values (1006,1,'SM-18277',3,6.99);
insert into LINE
values (1006,2,'2232/QTY',1,109.92);
insert into LINE
values (1006,3,'23109-HB',1,9.95);
insert into LINE
values (1006,4,'89-WRE-Q',1,256.99);
insert into LINE
values (1007,1,'13-Q2/P2',2,14.99);
insert into LINE
values (1007,2,'54778-2T',1,4.99);
insert into LINE
values (1008,1,'PVC23DRT',5,5.87);
insert into LINE
values (1008,2,'WR3/TT3',3,119.95);
insert into LINE
values (1008,3,'23109-HB',1,9.95);

commit;


