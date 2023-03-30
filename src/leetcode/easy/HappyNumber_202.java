package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    public static void main(String[] args) {
        System.out.println(1 / 10);
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
        System.out.println(isHappy(7));
        System.out.println(isHappy(3));
    }

    private static Set<Integer> set = new HashSet<>();

    public static boolean isHappy(int n) {
        set = new HashSet<>();
        return helper(n);
    }

    private static boolean helper(int n) {
        if (n == 1) {
            return true;
        }
        var sum = sum(n);
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);
        return helper(sum);
    }

    private static int sum(int n) {
        if (n < 10) {
            return n * n;
        }

        var result = 0;
        while (n != 0) {
            var a = n % 10;
            result += a * a;
            n = n / 10;
        }
        return result;
    }


    //true solution
    public boolean isHappyTrue(int n) {
        // Create a set to keep track of the numbers that have already been seen
        Set<Integer> seen = new HashSet<>();

        // Loop until either n becomes 1 (in which case n is a happy number) or n is seen again (in which case n is not a happy number)

        while (n != 1 && !seen.contains(n)) {
            // Add n to the set of seen numbers
            seen.add(n);

            // Compute the sum of the squares of the digits of n
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            // Update n with the sum of the squares of its digits

            n = sum;
        }

        // If n is 1, it is a happy number; otherwise, it is not
        return n == 1;
    }
}
