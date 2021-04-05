package hash;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s = "";
        String t = "";
        Anagram an = new Anagram();

        boolean res = an.isAnagram(s, t);
        System.out.println(res);
    }

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            map.put(sChars[i], map.getOrDefault(sChars[i], 0) + 1);
            map.put(tChars[i], map.getOrDefault(tChars[i], 0) - 1);
        }

        for (Character key : map.keySet()) {
            if (map.get(key) != 0) return false;
        }

        return true;
    }
}
