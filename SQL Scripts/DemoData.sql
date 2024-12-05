insert into doctor VALUES('D98871123',  326449799,  'John',     '',  'Samuel',  '256 Mountain Dr, Jacksonville, FL 32291',          9048891674,TO_DATE('09-15-1980','MM-DD-YYYY'),'');
insert into patient values('P02345678', 345221567, 'Alex',     '',     'Smith',          'MALE',     TO_DATE('05-23-1985','MM-DD-YYYY'), 'Stable',     '123 West Drive, Jacksonville, FL 36182,',     9041236588, '123 West Drive',      'Jacksonville', 'FL',   36182,  9041236588,'D98871123');
/*No secondary*/
insert into department values('Cardiology',       'CARD',     2251,   9041231134,'D98871123');
insert into operation values('VRC1345', 'Office Visit', 'Routine Visit', 30, 'CARD');
insert into operation values('XCH1235', 'X-Ray', 'X-ray showing chest', 15, 'CARD');
insert into medication values('Warfarin', 'Heart medication', 'JandJ');
insert into interactionrecord values(1, TO_DATE('04-20-2023','MM-DD-YYYY'), 'Call to ask a medical question', 'P02345678');
insert into undergo values('P02345678','D98871123',TO_DATE('04-24-2023','MM-DD-YYYY'),'Initial visit','VRC1345');
insert into prescription values('P02345678','D98871123',    TO_DATE('04-27-2023','MM-DD-YYYY'), 'Warfarin');