import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWords2 {
  @Test
  public void foo() {
    char[] in = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
    char[] out = new char[] {'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'};

//    char[] in = new char[] {'a','b',' ','c'};
//    char[] in = new char[] {'a',' ','b','c'};
//    char[] in = new char[] {'a',' ','b'};

    Reverser reverser = new TheirReverser();
    reverser.reverseWords(in);
    System.out.println(in);
  }

  interface Reverser {
    void reverseWords(char[] in);
  }

  static class TheirReverser implements Reverser {
    public void reverseWords(char[] chars) {
      reverse(chars, 0, chars.length);
      int start = 0;
      for (int i=0; i < chars.length; i++) {
        if (chars[i] == ' ' || i == chars.length - 1) {
          reverse(chars, start, i == chars.length - 1 ? i+1 : i);
          start = i + 1;
        }
      }
    }

    public void reverse(char[] chars, int start, int end) {
      if (start >= end) {
        return;
      }
      char c = chars[end-1];
      chars[end-1] = chars[start];
      chars[start] = c;
      reverse(chars, start+1, end-1);
    }
  }

  static class MyReverser implements Reverser {
    @Override
    public void reverseWords(char[] chars) {
      if (chars == null || chars.length == 0) {
        return;
      }
      reverseWords(chars, 0);
    }

    private void reverseWords(char[] chars, int start) {
      //check >=
      if (start > chars.length/2) {
        return;
      }
      int end = endWord(chars, start);
      int i = start;
      int j = chars.length -1 - start - end;
      while (i <= end) {
        char c =  chars[j];
        chars[j] = chars[i];
        chars[i] = c;
        i++;
        j++;
      }
      reverseWords(chars, end+1);
    }

    int endWord(char[] chars, int start) {
      for (int i = start; i < chars.length; i++) {
        if (chars[i] == ' ') {
          return i - 1;
        }
      }
      return chars.length - 1;
    }
  }

}
