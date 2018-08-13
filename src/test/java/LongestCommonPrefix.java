import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/longest-common-prefix/solution/
public class LongestCommonPrefix {
  private String[] inputs = {
      "leetsjjjjjjjjjj",
      "leetcodelllllll",
      "leetc",
      "leeds",
      "leedskkkkkkkk",
      "lee",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "leeds",
      "le"
  };
  int cont = 1000000;

  @Test
  public void tester() {
    foo1();
    foo2();
    foo3();
  }

  @Test
  public void foo1() {
    foo(new GetPrefix1());
  }

  @Test
  public void foo2() {
    foo(new GetPrefix2());
  }

  @Test
  public void foo3() {
    foo(new GetPrefix3());
  }

  public void foo(GetPrefix c) {
    long startTime = System.currentTimeMillis();
    String s = null;
    for (int i=0; i < cont; i++) {
      s = c.longestCommonPrefix(inputs);
    }
    if (!"le".equals(s)) {
      throw new IllegalStateException(s);
    }
    long endtime = System.currentTimeMillis();
    System.out.println(c.getClass().getName() + ": " + (endtime - startTime));
  }


  interface GetPrefix {
    String longestCommonPrefix(String[] strs);
  }

  static class GetPrefix1 implements GetPrefix {
    public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) {
        return "";
      }
      String prefix = strs[0];
      for (int i = 1; i < strs.length; i++)
        while (!strs[i].startsWith(prefix)) {
          prefix = prefix.substring(0, prefix.length() - 1);
          if (prefix.isEmpty()) {
            return "";
          }
        }
      return prefix;
    }
  }

  //830,810,803,788,776,766
  static class GetPrefix2 implements GetPrefix {
    @Override
    public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) {
        return "";
      }
      String prefix = strs[0];
      for (int i = 1; i < strs.length; i++) {
        String next = strs[i];
        prefix = prefix.length() < next.length() ? longestCommonPrefix(prefix, next) : longestCommonPrefix(next, prefix);
        if (prefix.isEmpty()) {
          return "";
        }
      }
      return prefix;
    }

    String longestCommonPrefix(String string1, String string2) {
      while (!string2.startsWith(string1)) {
        string1 = string1.substring(0, string1.length() - 1);
        if (string1.isEmpty()) {
          break;
        }
      }
      return string1;
    }

  }
  static class GetPrefix3 implements GetPrefix {

    @Override
    public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) {
        return "";
      }
      List<String> strings = Arrays.asList(strs);
      strings.sort(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return o1.length() - o2.length();
        }
      });
      String prefix = null;
      for (String next : strings) {
        if (prefix == null) {
          prefix = next;
        } else if (prefix.isEmpty()) {
          break;
        } else {
          prefix = longestCommonPrefix(prefix, next);
        }
      }
      return prefix;
    }

    String longestCommonPrefix(String string1, String string2) {
      while (!string2.startsWith(string1)) {
        string1 = string1.substring(0, string1.length() - 1);
        if (string1.isEmpty()) {
          break;
        }
      }
      return string1;
    }
  }
}
