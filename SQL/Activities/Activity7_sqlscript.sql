REM   Script: Activity7
REM   Activity7

SELECT SUM(PURCHASE_AMOUNT) AS total_purchase_amount 
FROM orders;

SELECT ROUND(AVG(PURCHASE_AMOUNT),0) AS average_purchase_amount 
FROM orders;

SELECT MAX(PURCHASE_AMOUNT) AS maximum_purchase_amount 
FROM orders;

SELECT MIN(PURCHASE_AMOUNT) AS minimum_purchase_amount 
FROM orders;

SELECT COUNT(DISTINCT SALESMAN_ID) AS total_salesman 
FROM orders;

