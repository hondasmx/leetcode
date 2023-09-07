package leetcode.sobes;

public class CodeSignal2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 2}));
    }

    static long solution(int[] a) {
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int mult = i == j ? 1 : 2;
                result += (long) a[i] * a[j] * mult;
            }
        }

        return result;
    }

}
