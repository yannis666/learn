import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbers {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  @Test
  public void doIt() {
    ListNode l342 = new ListNode(2);
    l342.next = new ListNode(4);
    l342.next.next = new ListNode(3);

    ListNode l465 = new ListNode(5);
    l465.next = new ListNode(6);
    l465.next.next = new ListNode(4);

    assertEquals(342, value(0, 1, l342));
    assertEquals(465, value(0, 1, l465));
  }

  private int value(int i, int multiplier, ListNode linked) {
    if (linked == null) {
      return i;
    }
    return value(i + (multiplier * linked.val), 10*multiplier, linked.next);
  }
}
