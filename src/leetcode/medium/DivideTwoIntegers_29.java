package leetcode.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * Return the quotient after dividing dividend by divisor.
 */
public class DivideTwoIntegers_29 {

    public static void main(String[] args) {
        System.out.println(divide(7, -3)); // -2
        System.out.println(divide(10, 3)); // 3
        System.out.println(divide(1, 1)); // 1
        System.out.println(divide(-1, 1)); // -1
        System.out.println(divide(-2147483648, -1)); // 2147483647
    }

    //true solution
    public static int divide2(int dividend, int divisor) {
        int sign;
        int result = 0;
        int value = 31;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            sign = 1;
        } else {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        while (ldividend >= ldivisor) {
            while (ldividend < ldivisor << value) {
                value--;
            }
            ldividend -= ldivisor << value;
            result += 1 << value;
        }
        if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) result = Integer.MAX_VALUE;
        result = sign > 0 ? result : -result;
        return result;
    }


    //too much memory in max_value / min_value
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        var lDividend = Math.abs((long) dividend);
        var lDivisor = Math.abs((long) divisor);
        if (lDividend == 0) {
            return 0;
        }

        long result = 0;
        var diff = -1;
        if (dividend >= 0 && divisor >= 0 || dividend <= 0 && divisor <= 0) {
            diff = 1;
        }
        while (lDivisor * result <= lDividend) {
            result += 1;
        }

        long res = (result - 1) * diff;
        if (res > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
