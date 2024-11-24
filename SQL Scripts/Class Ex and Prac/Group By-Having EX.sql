SELECT p.Pnumber, p.Pname, Count(*)
FROM PROJECT p, WORKS_ON w
WHERE Pno = Pnumber 
GROUP BY Pnumber;

SELECT Dno, Count(*)
FROM DEPARTMENT, EMPLOYEE
WHERE Salary > 40000 and 
Dno IN
(SELECT Dno 
FROM Employee 
GROUP BY Dno
HAVING Count(*) > 2)
GROUP BY Dno;


SELECT DNO
FROM Employee
GROUP BY Dno
HAVING COUNT(*) > 2;