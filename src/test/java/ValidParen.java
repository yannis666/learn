import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParen {

  @Test
  public void test() {
    Resolver resolver = new MyResolver();
    assertTrue(resolver.resolve("()"));
    assertTrue(resolver.resolve("()[]{}"));
    assertFalse(resolver.resolve("(]"));
    assertFalse(resolver.resolve("([)]"));
    assertTrue(resolver.resolve("{[]}"));
    assertTrue(resolver.resolve("{[()]}"));
  }

  interface Resolver {
    boolean resolve(String in);
  }

  static class MyResolver implements Resolver {

    @Override
    public boolean resolve(String in) {
      Stack<Character> stack = new Stack<>();
      for (char c : in.toCharArray()) {
        switch (c) {
          case '{':
          case '[':
          case '(':
            stack.push(c);
            break;
          case '}':
            if (stack.isEmpty() || stack.pop() != '{') {
              return false;
            }
            break;
          case ']':
            if (stack.isEmpty() || stack.pop() != '[') {
              return false;
            }
            break;
          case ')':
            if (stack.isEmpty() || stack.pop() != '(') {
              return false;
            }
            break;
          default:
            throw new IllegalStateException();

        }
      }
      return stack.isEmpty();
    }
  }
}
