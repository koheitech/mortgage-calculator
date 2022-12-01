# README - Mosh Mortgage Calculator
This is the study project for [Mosh Ultimate Java course](https://codewithmosh.com/p/the-ultimate-java-mastery-series).  
Based on the sample program, some refactor and modifications were made.  
This java program is going to;  
- input the information from user
- calculate the mortgage
- output the mortgage and remaining balance

# How to run
You can clone this repo and run `Main.java`

# How to calculate mortgage
## Mortgage formula
```
M = P( (r(1 + r)^n) ) / ((1 + r)^n - 1) )
```
Where;
- Mortgage -> M
- Principle(US dollar) -> P
- Monthly Interest Rate: -> r
- Number of payment in month -> n

## Formula to calculate remaining balance
THe formula to calculate the remaining loan balance of payment after p month.
```
B = L( ((1 + c)^n - (1 + c)^p) / ((1 + c)^n - 1) ) 
```
Where;
- Remaining balance -> B
- Monthly interest -> c
- Number of payment in month -> n
- Number of payment we have made -> p

# Input from user
- Principle in US dollars
- Annual Interest rate
- Period in years
