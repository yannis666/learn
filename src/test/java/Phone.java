import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone {

  @Test
  public void toDo() {
    List<String> strings = new Solution().letterCombinations("23");
    System.out.println(strings);
  }

  static class Solution {
    private  static final Map<Character, char[]> LETTER_MAP = new HashMap<>();
    static {
      LETTER_MAP.put('2', "abc".toCharArray());
      LETTER_MAP.put('3', "def".toCharArray());
      LETTER_MAP.put('4', "ghi".toCharArray());
      LETTER_MAP.put('5', "jkl".toCharArray());
      LETTER_MAP.put('6', "mno".toCharArray());
      LETTER_MAP.put('7', "pqrs".toCharArray());
      LETTER_MAP.put('8', "tuv".toCharArray());
      LETTER_MAP.put('9', "wxyz".toCharArray());
    }

    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if (digits.isEmpty()) return result;

      char[][] letters = new char[digits.length()][];
      for (int i = 0; i < digits.length(); i++) {
        letters[i] = LETTER_MAP.get(digits.charAt(i));
      }

      getCombination("", 0, letters, result);

      return result;
    }

    private void getCombination(String word, int index, char[][] letters, List<String> result) {
      char[] charsForDigit = letters[index];
      for (char c : charsForDigit) {
        if (index + 1 == letters.length) {
          result.add(word + c);
        } else {
          getCombination(word + c, index + 1, letters, result);
        }
      }
    }
  }

}
