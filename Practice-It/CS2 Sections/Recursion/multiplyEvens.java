/*
    Write a method multiplyEvens that returns the product of the first
    n even integers. For example:
    multiplyEvens(1) = 2 = 2
    multiplyEvens(2) = 2 * 4 = 8
    multiplyEvens(3) = 2 * 4 * 6 = 48
    multiplyEvens(4) = 2 * 4 * 6 * 8 = 384
    You should throw an IllegalArgumentException if passed a value
    less than or equal to 0
*/

public static int multiplyEvens(int n) {
    if (n <= 0)
        throw new IllegalArgumentException("n <= 0");
    else if (n == 1)
        return 2;
    else
        return 2 * n * multiplyEvens(n - 1);
}