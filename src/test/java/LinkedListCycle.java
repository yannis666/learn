public class LinkedListCycle {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public boolean checkLoop(ListNode node) {
    ListNode one = node;
    ListNode two = node;
    while (two != null && two.next != null) {
      one = one.next;
      two = two.next.next;
      if (one == two) return true;
    }
    return false;
  }
}
