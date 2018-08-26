import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbers2 {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  @Test
  public void doIt() {
    ListNode l342 = new ListNode(3);
    l342.next = new ListNode(4);
    l342.next.next = new ListNode(2);

    ListNode l465 = new ListNode(4);
    l465.next = new ListNode(6);
    l465.next.next = new ListNode(5);

    assertEquals(342, value(0, l342));
    assertEquals(465, value(0, l465));
  }

  int value(int i, ListNode node) {
    if (node == null) {
      return i;
    }
    return value(i*10 + node.val, node.next);
  }
}
