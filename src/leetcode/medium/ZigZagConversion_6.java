package leetcode.medium;

public class ZigZagConversion_6 {
    public static void main(String[] args) {
        System.out.println(convert("AAA", 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        var result = new StringBuilder();
        var zagSize = numRows + numRows - 2; //для numRows = 4 -> 6
        for (int i = 0; i < numRows; i++) {
            var index1 = i;
            var index2 = zagSize - i;
            while (index1 < s.length() || index2 < s.length()) {
                if (index1 == index2) {
                    index2 = s.length();
                }
                if (index1 < s.length()) {
                    result.append(s.charAt(index1));
                    index1 += zagSize;
                    if (index1 == index2) {
                        index1 += zagSize;
                    }
                }
                if (index2 < s.length()) {
                    result.append(s.charAt(index2));
                    index2 += zagSize;
                    if (index1 == index2) {
                        index2 += zagSize;
                    }
                }
            }
        }



        return result.toString();
        //4 rows//
        //0, 6, 12 //4 + (4-2) = 6
        //1, 5, 7, 11, 13
        //2, 4, 8, 10,
        //3, 9,


        //3 rows
        //0, 4, 8, 12 (3 + (3-2) = 4)
        //1, 3, 5, 7,9,11,13
        //2, 6, 10, 14
    }
}
