/*Department Values             Dname           DCODE       OFFICE  PHONE       DoctorID*/
insert into department values('Oncology',       'ONCO',     2000,   1002001000,'');
insert into department values('Neurology',      'NEUR',     1000,   1002200000,'');
insert into department values('Pediatrics',     'PEDI',     2020,   1220000111,'');
insert into department values('Dermatology',    'DERM',     1000,   2227778888,'');
insert into department values('Parmacy',        'PHAR',     2000,   7770005555,'');
insert into department values('Dentistry',      'DENT',     3000,   3330006666,'');
insert into department values('Proctology',     'PROC',     3000,   3331115555,'');

/*Doctor Values             Doctor ID   SSN         FNAME       MI      LASTNAME    Address                                         Phone     DOB                                DCODE*/
insert into doctor VALUES('D10010000',  111002222,  'Dave',     'J',    'Johnson',  '1 UNF Drive, Jacksonville FL, 32256',          6660002222,TO_DATE('02-09-1965','MM-DD-YYYY'),'PROC');
insert into doctor VALUES('D11110000',  222552222,  'James',    'K',    'Wilson',   '2231 Beach Blvb, Jacksonville FL, 32189',      2310005555,TO_DATE('10-09-1985','MM-DD-YYYY'),'PEDI');
insert into doctor VALUES('D22222222',  111669999,  'Brandon',  'F',    'Winston',  '2033 Horizon Lane, Jacksonville FL, 30056',    1110002222,TO_DATE('09-27-2000','MM-DD-YYYY'),'NEUR');
insert into doctor VALUES('D22221000',  312950422,  'Seville',  '',     'Setoe',    '1341 Komhs Drive, Jacksonville FL, 32239',     7770001111,TO_DATE('02-26-1975','MM-DD-YYYY'),'DERM');
insert into doctor VALUES('D12345678',  135342354,  'Harlette', '',     'Harvey',   '5671 Mo Road, Jacksonville FL, 32464',         8880009999,TO_DATE('08-07-1968','MM-DD-YYYY'),'NEUR');
insert into doctor VALUES('D22335506',  113693453,  'Nora',     'U',    'Jones',    '9464 Ewe Grove, Jacksonville FL, 32674',       2220007777,TO_DATE('07-24-1969','MM-DD-YYYY'),'DENT');
insert into doctor VALUES('D12403134',  113591593,  'Leya',     'E',    'Lindholm', '6464 University Blvd, Jacksonville FL, 32116', 5550005522,TO_DATE('05-10-1970','MM-DD-YYYY'),'ONCO');
insert into doctor VALUES('D12340522',  359379219,  'Stefan',   '',     'Bjorn',    '4661 Onglo Road, Jacksonville FL, 32004',      6660002666,TO_DATE('04-11-1980','MM-DD-YYYY'),'ONCO');
insert into doctor VALUES('D24560392',  925794329,  'Patricia', '',     'Koll',     '4716 Way way, Jacksonville FL, 32156',         7770002789,TO_DATE('12-23-1999','MM-DD-YYYY'),'PHAR');
insert into doctor VALUES('D05391905',  935793932,  'William',  'T',    'Borson',   '8956 Maglo Parkway, Jacksonville FL, 32009',   4440002457,TO_DATE('02-28-1987','MM-DD-YYYY'),'PHAR');

/*Patient Values            Patient ID  SSN         FNAME       MI      LNAME           Sex         DOB                                 Condition       Curr Address    Currphon    Perm Add            City            State   Zip     PermPhone  Doctor ID */
insert into patient values('P11110000', 111222333, 'John',     '',     'Doe',          'MALE',     TO_DATE('02-09-1965','MM-DD-YYYY'), 'Critical',     'Curradd1',     1110001111, '1 Perm Adder',      'Jacksonville', 'GA',   32412,  1110023411,'D10010000');
insert into patient values('P10200000', 132525323, 'Jane',     '',     'Doe',          'FEMALE',   TO_DATE('02-09-1965','MM-DD-YYYY'), 'Stable',       'Curradd2',     2220002312, '2 Perm Adder',      'Jacksonville', 'GA',   33242,  1138039533,'D22222222');
insert into patient values('P20312054', 113434534, 'William',  'T',    'Emoe',         'MALE',     TO_DATE('02-09-1965','MM-DD-YYYY'), 'Fair',         'Curradd3',     1132049435, '3 Perm Adder',      'Jacksonville', 'ME',   33112,  2949049224,'D11110000');
insert into patient values('P24953935', 113535332, 'Beatriz',  'Y',    'Kerlo',        'FEMALE',   TO_DATE('02-09-1965','MM-DD-YYYY'), 'Fair',         'Curradd4',     2495094304, '4 Perm Adder',      'Jacksonville', 'NY',   32342,  1345089011,'D22221000');
insert into patient values('P34296503', 133232523, 'Gino',     'S',    'Kenos',        'MALE',     TO_DATE('02-09-1965','MM-DD-YYYY'), 'Stable',       'Curradd5',     1839039633, '5 Perm Adder',      'Jacksonville', 'FL',   12452,  1189053033,'D12345678');
insert into patient values('P54030178', 352352352, 'Jomes',    'B',    'Wateo',        'OTHER',    TO_DATE('02-09-1965','MM-DD-YYYY'), 'Stable',       'Curradd6',     1295030935, '6 Perm Adder',      'Jacksonville', 'FL',   14122,  1109050381,'D22335506');
insert into patient values('P53894759', 115135155, 'Xore',     '',     'Watanabe',     'NONE',     TO_DATE('02-09-1965','MM-DD-YYYY'), 'Critical',     '',             2953084939, '7 Perm Adder',      'Jacksonville', 'FL',   33112,  1231024114,'D12403134');
insert into patient values('P35489347', 189373933, 'Feasto',   'N',    'Orpl',         'MALE',     TO_DATE('02-09-1965','MM-DD-YYYY'), 'Critical',     '',             3065083472, '8 Perm Adder',      'Jacksonville', 'FL',   33212,  3542033636,'D12340522');
insert into patient values('P43658093', 953839933, 'Preiq',    'M',    'Lindol',       'FEMALE',   TO_DATE('02-09-1965','MM-DD-YYYY'), 'Fair',         'Curradd7',     0398038953, '9 Perm Adder',      'Jacksonville', 'FL',   33112,  1241027744,'D24560392');
insert into patient values('P22220000', 295913603, 'Franko',   'Z',    'Bjoprneos',    'MALE',     TO_DATE('02-09-1965','MM-DD-YYYY'), 'Stable',       'Curradd8',     8573003685, '10 Perm Adder',     'Jacksonville', 'FL',   33112,  1241024124,'D10010000');
insert into patient values('P11113333', 134636436, 'Dakota',   'E',    'Zeo',          'FEMALE',   TO_DATE('02-09-1965','MM-DD-YYYY'), 'Critical',     '',             2890053893, '11 Perm Adder',     'Jacksonville', 'FL',   33112,  1110001111,'D05391905');

/*Medications                   Mname               Descrip                             Manufacture*/
insert into medication values('Oxycodone',          'Pain Reliever',                    'Generic');
insert into medication values('Doxepin',            'Anxiety and Depression',           'Marlo');
insert into medication values('Lisdexamfetamine',   'ADHD',                             'Generic');
insert into medication values('Semaglutide',        'Weight-loss/Antidiabetic',         'Ozempic');
insert into medication values('Insulin',            'Diabetes',                         'Generic');

/*Procedures                PNumber     Pname       PDesc  Pduration OfferDep*/
insert into operation values('ONC1234', 'Pname1', 'PDesc1',100, 'ONCO');
insert into operation values('PRC1346', 'Pname2', 'PDesc2',200, 'PROC');
insert into operation values('PED1889', 'Pname3', 'PDesc3',330, 'PEDI');
insert into operation values('NEU7666', 'Pname4', 'PDesc4',229, 'NEUR');
insert into operation values('DER4444', 'Pname5', 'PDesc5',238, 'DERM');
insert into operation values('DEN2234', 'Pname6', 'PDesc6',109, 'DENT');

/*Interaction records               ID  Date        Desc         PID*/
insert into interactionrecord values(1, SYSDATE, 'Record1:1', 'P11110000');
insert into interactionrecord values(2, SYSDATE, 'Record1:2', 'P11110000');
insert into interactionrecord values(3, SYSDATE, 'Record1:3', 'P11110000');
insert into interactionrecord values(1, SYSDATE, 'Record2:1', 'P10200000');
insert into interactionrecord values(2, SYSDATE, 'Record2:2', 'P10200000');
insert into interactionrecord values(3, SYSDATE, 'Record2:3', 'P10200000');
insert into interactionrecord values(1, SYSDATE, 'Record3:1', 'P11113333');

/*Secondary Doctors                 PatientID   DoctorID*/
insert into secondarydoctor values('P11110000','D22222222');
insert into secondarydoctor values('P11113333','D22222222');
insert into secondarydoctor values('P43658093','D05391905');
insert into secondarydoctor values('P43658093','D22222222');

/*undergo and prescriptions*/
/*                          PatientID   DoctorID    Date                                Notes   Pnumber*/
insert into undergo values('P11110000','D22222222',TO_DATE('02-09-1965','MM-DD-YYYY'),'Notes1','ONC1234');
insert into undergo values('P11113333','D22222222',TO_DATE('02-09-1965','MM-DD-YYYY'),'Notes2','PRC1346');
insert into undergo values('P43658093','D05391905',TO_DATE('02-09-1965','MM-DD-YYYY'),'Notes3','NEU7666');
insert into undergo values('P43658093','D22222222',TO_DATE('02-09-1965','MM-DD-YYYY'),'Notes4','DEN2234');
/*                              PatientID   DoctorID        Date                                Mname*/
insert into prescription values('P11110000','D22222222',    TO_DATE('02-09-1965','MM-DD-YYYY'), 'Oxycodone');
insert into prescription values('P11113333','D22222222',    TO_DATE('02-09-1965','MM-DD-YYYY'), 'Insulin');
insert into prescription values('P43658093','D05391905',    TO_DATE('02-09-1965','MM-DD-YYYY'), 'Doxepin');
insert into prescription values('P24953935','D22222222',    TO_DATE('02-09-1965','MM-DD-YYYY'), 'Semaglutide');