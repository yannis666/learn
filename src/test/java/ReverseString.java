import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

//https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/187/
public class ReverseString {
  @Test
  public void doIt() {
    doIt(new Reverser1());
  }

  private void doIt(Reverser r) {
    assertNull(r.reverse(null));
    assertEquals("", r.reverse(""));
    assertEquals("a", r.reverse("a"));
    assertEquals("ytrewq", r.reverse("qwerty"));
    assertEquals("amanaP :lanac a ,nalp a ,nam A", r.reverse("A man, a plan, a canal: Panama"));
  }

  interface Reverser {
    String reverse(String input);
  }

  static class Reverser1 implements Reverser {
    @Override
    public String reverse(String input) {
      if (input == null) {
        return null;
      }
      if (input.isEmpty()) {
        return "";
      }
      StringBuilder ret = new StringBuilder();
      for (int i=input.length() - 1; i >= 0; i--) {
        ret.append(input.charAt(i));
      }
      return ret.toString();
    }
  }
}
