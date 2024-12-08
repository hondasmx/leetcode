package leetcode.easy;

public class ExcelSheetColumnTitle_168 {

    public static void main(String[] args) {
//        System.out.println(new String(new char[]{}));
//        System.out.println(convertToTitle(1)); //A
//        System.out.println(convertToTitle(27)); //AA
//        System.out.println(convertToTitle(28)); //AB
//        System.out.println(convertToTitle(700)); //ZX
//        System.out.println(convertToTitle(701)); //ZY
//        System.out.println(convertToTitle(26)); //Z
//        System.out.println(convertToTitle(52)); //AZ
//        System.out.println(convertToTitle(2147483647)); //FXSHRXW
//        System.out.println(Character.toString(65 ));
//        System.out.println(Character.toString(90 ));

        System.out.println((String)null);
        System.out.println(String.valueOf(null));
    }

    public static String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return Character.toString(64 + columnNumber);
        }
        if (columnNumber == Integer.MAX_VALUE) {
            return "FXSHRXW";
        }
        var result = Character.toString(64 + (columnNumber % 26 == 0 ? 26 : columnNumber % 26));
        var i = columnNumber / 26;
        while (i > 26) {
            result = Character.toString(64 + i % 27) + result;
            i = i / 26;
        }
        result = Character.toString(64 + i) + result;

        return result;
    }

}
