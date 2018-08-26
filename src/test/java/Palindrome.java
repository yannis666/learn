import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Palindrome {
  @Test
  public void doIt() {
    MyPalindrome it = new MyPalindrome();
    System.out.println(it.palindrome("babadkpogopk"));
    //System.out.println(it.palindrome("cbbd"));
    //babadkpogopk
    //012345678901
  }

  private class MyPalindrome {
    String palindrome(String s) {
      int pos = 0;
      int len = 0;
      if (s == null || s.length() == 0) {
        return "";
      }
      char[] chars = s.toCharArray();
      if (chars.length == 1) {
        return s;
      } else if (chars.length < 3) {
        return String.valueOf(chars[0]);
      }
      //divide & conquer - look for candidates;
      for (int i = 1; i < chars.length - 2; i++) {
        int thisLen = maxPalindromeAt(i, chars);
        System.out.println("i=" + i + ", c=" + chars[i] + ", thisLen=" + thisLen + "||| pos=" + pos + ", len=" + len);
        if (thisLen > len) {
          pos = i;
          len = thisLen;
        }
      }
      StringBuilder sb = new StringBuilder();
      for (int i = len; i > 0; i--) {
        sb.append(chars[pos-i]);
      }
      sb.append(chars[pos]);
      for (int i=1; i <= len; i++) {
        sb.append(chars[pos+i]);
      }
      return sb.toString();
    }

    int maxPalindromeAt(int i, char[] chars) {
      int maxJ = Math.min(i, chars.length - i - 1);
      if (i==8) {
        System.out.println();
      }
      for (int j=1; j <= maxJ; j++) {
        if (chars[i-j] != chars[i+j]) {
          return j - 1;
        }
      }
      return maxJ;
    }
  }
}
