import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationOfAPhoneNumber_17 {


    public static void main(String[] args) {
        System.out.println(letterCombinations("234")); //["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("23")); //["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("2")); //["a","b","c"]
    }
    public static List<String> letterCombinations(String digits) {
        Map<String, String[]> map = new HashMap<>();
        map.put("2", new String[]{"abc"});
        map.put("3", new String[]{"def"});
        map.put("4", new String[]{"ghi"});
        map.put("5", new String[]{"jkl"});
        map.put("6", new String[]{"mno"});
        map.put("7", new String[]{"pqrs"});
        map.put("8", new String[]{"tuv"});
        map.put("9", new String[]{"wxyz"});

        if (digits.isBlank()) {
            return List.of();
        }
        var result = new ArrayList<String>();

        var split = digits.split("");
        var words = Arrays.stream(split).map(map::get).toList();

        for (String word0 : words.get(0)[0].split("")) {
            var sb = new StringBuilder();
            var next1 = words.size() > 1 ? words.get(1)[0].split("") : new String[]{""};
            for (String word1 : next1) {
                var next2 = words.size() > 2 ? words.get(2)[0].split("") : new String[]{""};
                for (String word2 : next2) {
                    var next3 = words.size() > 3 ? words.get(3)[0].split("") : new String[]{""};
                    for (String word3 : next3) {
                        sb.append(word0);
                        sb.append(word1);
                        sb.append(word2);
                        sb.append(word3);
                        result.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }

            }
        }
        return result;
    }

    /**
     * Backtrack true solution
     */
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;

    public List<String> letterCombinations_true(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
}
