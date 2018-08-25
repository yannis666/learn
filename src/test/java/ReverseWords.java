import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWords {
  @Test
  public void foo() {
    String in = "the sky   is    blue  ";
    String out = "blue is sky the";
    Reverser reverser = new MyReverser();
    assertEquals(out, reverser.reverseWords(in));
  }

  interface Reverser {
    String reverseWords(String in);
  }

  static class MyReverser implements Reverser {

    @Override
    public String reverseWords(String in) {
      if (in == null) {
        return null;
      }
      in = in.trim();
      if (in.length() == 0) {
        return "";
      }
      String[] s = in.split(" +");

      StringBuilder sb = new StringBuilder();
      for (int i = s.length - 1; i >= 0; i--) {
        sb.append(s[i]);
        if (i != 0) {
          sb.append(" ");
        }
      }
      return sb.toString();
    }
  }
}
