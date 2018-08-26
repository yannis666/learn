import org.junit.Test;

public class ReverseLinkedList {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  @Test
  public void doIt() {
    ListNode data = create(5);
    System.out.println();

    ListNode previous = null;
    ListNode current = data;
    while (current != null) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    data = previous;
    System.out.println();
  }

  private ListNode create(int count) {
    ListNode first = new ListNode(1);
    ListNode last = first;
    for (int i=2; i<=count; i++) {
      last.next = new ListNode(i);
      last = last.next;
    }
    return first;
  }
}
