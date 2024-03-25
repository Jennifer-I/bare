-- Given two tables (T1 and T2) below, write a Structured Query Language (MySql | Postgres | Oracle)
-- that when executed returns the ordered records in T1 but NOT in T2, as Output.Given two tables (T1 and T2) below,
-- write a Structured Query Language (MySql | Postgres | Oracle) that when executed returns the ordered records in T1
-- but NOT in T2, as Output.

SELECT T1.id, T1.name, T1.age
FROM T1
         LEFT JOIN T2 ON T1.id = T2.id AND T1.name = T2.name
WHERE T2.id IS NULL
ORDER BY T1.id;

