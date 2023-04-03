import java.util.*;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String p1 = words[i].substring(0, j);
                String p2 = words[i].substring(j);
                if (isPalindrome(p1)) checkReverse(p2, i, map, res, true);
                if (isPalindrome(p2)) checkReverse(p1, i, map, res, false);
            }
        }
        return res;
    }

    private void checkReverse(String s, int i, Map<String, Integer> map, List<List<Integer>> res, boolean addToFront) {
        String sr = reverse(s);
        int id = map.getOrDefault(sr, i);
        if (id != i) {
            if (addToFront) res.add(Arrays.asList(id, i));
            else res.add(Arrays.asList(i, id));
            if (sr.length() == 0) res.add(Arrays.asList(id, i));
        }
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
