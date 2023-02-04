package leetcode.easy;

public class MySqrt_69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));

    }

    public static int mySqrt(int x) {
        long answer = 1;
        while (answer * answer <= x) {
            answer++;
        }
        return (int)answer - 1;
    }
}
