package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AnagramGroup {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new AnagramGroup().groupAnagrams(strs);
        System.out.println(lists);

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new LinkedList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            //将计数的数字作为key
            String key = String.valueOf(count);
            if (!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(str);
        }

        return new LinkedList<>(map.values());
    }
}
