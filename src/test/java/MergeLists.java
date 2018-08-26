import org.junit.Test;

public class MergeLists {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  @Test
  public void doIt() {
    ListNode l124 = new ListNode(1);
    l124.next = new ListNode(2);
    l124.next.next = new ListNode(4);

    ListNode l134 = new ListNode(1);
    l124.next = new ListNode(3);
    l124.next.next = new ListNode(4);

    ListNode listNode = new Solution().mergeTwoLists(l124, l134);
    System.out.println();

  }


  static class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        if (l2 == null) {
          return null;
        }
        return copy(l2);
      } else if (l2 == null) {
        return copy(l1);
      }
      final ListNode ret;
      if (l1.val <= l2.val) {
        ret = copy(l1);
        mergeInto(ret, l2);
      } else {
        ret = copy(l2);
        mergeInto(ret, l1);
      }
      return ret;
    }

    private void mergeInto(ListNode current, ListNode l1) {
      if (l1 == null) {
        return;
      }
      if (current.next == null) {
        l1 = copy(l1);
        current.next = l1;
        return;
      }
      ListNode next = current.next;
      if (l1.val < next.val) {
        current.next = new ListNode(l1.val);
        current.next.next = next;
        l1 = l1.next;
      }
      mergeInto(current.next, l1);
    }

    private ListNode copy(ListNode l1) {
      ListNode first = new ListNode(l1.val);
      ListNode current = first;
      while (l1.next != null) {
        l1 = l1.next;
        current.next = new ListNode(l1.val);
        current = current.next;
      }
      return first;
    }
  }
}
