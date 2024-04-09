package April_08_Assignment;
import java.util.ArrayList;
import java.util.Scanner;

public class Q2_Solution {
    public int minJumps(String A) {
        int n = A.length();
        ArrayList<Integer> occupiedSeats = new ArrayList<>();

        // Finding occupied seats
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                occupiedSeats.add(i);
            }
        }

        int m = occupiedSeats.size();

        // If all seats are already occupied, return 0
        if (m == 0 || m == n) {
            return 0;
        }

        // Calculate median index of occupied seats
        int medianIndex = occupiedSeats.get(m / 2);

        // Calculate total jumps required to make everyone sit together
        int totalJumps = 0;
        for (int i = 0; i < m; i++) {
            totalJumps += Math.abs(occupiedSeats.get(i) - medianIndex) - Math.abs(i - m / 2);
        }

        return totalJumps % 10000003;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q2_Solution solution = new Q2_Solution();

        System.out.println("Enter the string representing the row of seats:");
        String A = scanner.next();

        System.out.println("Minimum number of jumps required: " + solution.minJumps(A));
    }
}
