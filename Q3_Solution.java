package April_08_Assignment;

import java.util.Scanner;

public class Q3_Solution {
    public int minFibonacciNumbers(int A) {
        int count = 0;
        int a = 0, b = 1;

        while (a <= A) {
            int temp = a;
            a = b;
            b = temp + b;
            count++;
        }

        int fibSum = 0;
        int fibCount = 0;
        int fibNumber = b; // b is the last Fibonacci number that is greater than A

        // Greedily choose Fibonacci numbers until their sum equals A
        while (fibSum != A) {
            if (fibSum + fibNumber <= A) {
                fibSum += fibNumber;
                fibCount++;
            }
            fibNumber = (b - a);
            b = a;
            a = fibNumber;
        }

        return fibCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q3_Solution solution = new Q3_Solution();

        System.out.println("Enter the value of A:");
        int A = scanner.nextInt();

        System.out.println("Minimum number of Fibonacci numbers required: " + solution.minFibonacciNumbers(A));
    }
}
