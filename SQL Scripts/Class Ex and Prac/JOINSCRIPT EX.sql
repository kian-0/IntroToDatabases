SELECT *
FROM employee NATURAL JOIN 
(SELECT DNAME, DNUMBER AS DNO,MGRSSN,MGRSTARTDATE FROM DEPARTMENT);

SELECT * 
FROM EMPLOYEE JOIN DEPARTMENT ON dno=dnumber;

SELECT *
FROM EMPLOYEE E RIGHT JOIN DEPARTMENT D ON E.SSN =D.MGRSSN;

/*BOTTOM THREE HAVE THE SAME OUTPUT*/
SELECT E.FNAME, E.LNAME, D.DLOCATION
FROM EMPLOYEE E JOIN DEPT_LOCATIONS D ON E.DNO=D.DNUMBER;

SELECT FNAME, LNAME, DLOCATION
FROM EMPLOYEE NATURAL JOIN (SELECT DNUMBER AS DNO, DLOCATION FROM DEPT_LOCATIONS);

SELECT E.FNAME, E.LNAME, D.DLOCATION
FROM EMPLOYEE E RIGHT JOIN DEPT_LOCATIONS D ON E.DNO=D.DNUMBER;

/*AGGREGATE FUNCTIONS*/
SELECT SUM(SALARY), MAX(SALARY), MIN(SALARY), AVG(SALARY)
FROM EMPLOYEE;


