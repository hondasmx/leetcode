package leetcode.easy;

import java.util.Arrays;

public class ExcelSheetColumnNumber_171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {
        var result = 0;
        var split = columnTitle.split("");
        for (int i = 0; i < split.length; i++) {
            var s = split[split.length - 1 - i];
            result += Math.pow(26, i) * (s.getBytes()[0] - 64);
        }
        return result;
    }

}
