public class LengthOfLastWord_58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String[] split = s.split(" ");
        return split[split.length - 1].length();


        //official solution
//        s = s.trim();  // trim the trailing spaces in the string
//        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
