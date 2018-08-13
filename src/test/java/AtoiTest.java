import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/171/
public class AtoiTest {


  @Test
  public void doIt() {
    doIt(new Atoi1());
    doIt(new Atoi2());
  }

  public void doIt(Atoi inst) {
    long start = System.currentTimeMillis();
    assertEquals(Integer.MIN_VALUE, inst.atoi(" " + Integer.MIN_VALUE + "abcdefg"));
    assertEquals(Integer.MIN_VALUE, inst.atoi("" + Integer.MIN_VALUE));
    assertEquals(Integer.MIN_VALUE + 1, inst.atoi(" " + (Integer.MIN_VALUE + 1) + "abcdefg"));
    assertEquals(Integer.MIN_VALUE + 1, inst.atoi("" + (Integer.MIN_VALUE + 1)));
    assertEquals(Integer.MIN_VALUE, inst.atoi(" " + (((long)Integer.MIN_VALUE) - 1) + "abcdefg"));
    assertEquals(Integer.MIN_VALUE, inst.atoi("" + (((long)Integer.MIN_VALUE) - 1)));

    for (int i = -100000 ; i < 100000; i++) {
      assertEquals(i, inst.atoi("" + i));
      assertEquals(i, inst.atoi("   " + i));
      assertEquals(i, inst.atoi("   " + i + " 123456"));
    }

    assertEquals(Integer.MAX_VALUE, inst.atoi(" " + Integer.MAX_VALUE + "abcdefg"));
    assertEquals(Integer.MAX_VALUE, inst.atoi("" + Integer.MAX_VALUE));
    assertEquals(Integer.MAX_VALUE - 1, inst.atoi(" " + (Integer.MAX_VALUE - 1) + "abcdefg"));
    assertEquals(Integer.MAX_VALUE - 1, inst.atoi("" + (Integer.MAX_VALUE - 1)));
    assertEquals(Integer.MAX_VALUE, inst.atoi(" " + (((long)Integer.MAX_VALUE) + 1) + "abcdefg"));
    assertEquals(Integer.MAX_VALUE, inst.atoi("" + ((long)Integer.MAX_VALUE) + 1));

    long end = System.currentTimeMillis();
    System.out.println(inst.getClass().getName() + ": " + (end-start));
  }

  interface Atoi {
    int atoi(String input);
  }

  static class Atoi1 implements Atoi {
    private static final Pattern INTEGER = Pattern.compile("(^[ ]*)([+-]{0,1}\\d{1,})([^\\d]*)");

    @Override
    public int atoi(String input) {
      Matcher matcher = INTEGER.matcher(input);
      if (matcher.find()) {
        String intString = matcher.group(2);
        try {
          return Integer.parseInt(intString, 10);
        } catch (NumberFormatException e) {
          return intString.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
      } else {
        return 0;
      }
    }
  }

  static class Atoi2 implements Atoi {
    public int atoi(String str) {
      if (str == null) return 0;

      int i = 0, sign = 1;
      long res = 0;

      str = str.trim();

      if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
        sign = str.charAt(i++) == '-' ? -1 : 1;
      }

      while (i < str.length() && Character.isDigit(str.charAt(i))) {
        res = 10 * res + sign * (str.charAt(i++) - '0');
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
      }

      return (int) res;
    }

  }
}
