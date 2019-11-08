/*
    Write a method factorial that accepts an integer parameter n and that uses
    recursion to compute and return the value of n factorial (also known as n!).
    Your method should throw an IllegalArgumentException if n is negative.
*/


public static int factorial(int n) {
    if (n < 0)
        throw new IllegalArgumentException("n < 0");
    else if (n == 0 || n == 1)
        return 1;
    else
        return n * factorial(n - 1);
}