import java.util.Arrays;
import java.util.stream.Collectors;

public class PlusOne_99 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
    }

    public static int[] plusOne(int[] digits) {
        int[] newArray = new int[digits.length + 1];
        boolean useNewArray = false;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        int index = digits.length - 1;
        while (digits[index] > 9) {
            digits[index] = 0;
            if (index == 0) {
                System.arraycopy(digits, 0, newArray, 1, digits.length);
                newArray[0] = 1;
                useNewArray = true;
                break;
            }
            digits[index - 1]++;
            index--;
        }
        return useNewArray ? newArray : digits;
    }
}
