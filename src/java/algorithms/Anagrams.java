package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * check if the given strings is anagram
 */
public class Anagrams {

    static boolean anagram(String s1, String s2) {
        Objects.requireNonNull(s1, "String must not be null");
        Objects.requireNonNull(s2, "String must not be null");
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!counts.containsKey(c)) {
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }
            counts.put(c, counts.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        /*String s1 = "a";
        String s2 = "b";
        System.out.println(anagram(s1, s2));*/
        System.out.println("abc de  fe   f    g".replaceAll("\\s{2}", ""));
    }
}
