public class Queue<T> {

  private Node<T> first = null;
  private Node<T> last = null;

  private final Object lock = new Object();

  private static class Node<T> {
    private T value = null;
    private Node<T> next = null;
  }

  void enqueue(T item) {
    Node<T> newNode = new Node<T>();
    synchronized (lock) {
      if (first == null) {
        first = newNode;
        first.value = item;
      } else {
        last.next = newNode;
      }
      last = newNode;
    }
  }

  T dequeue(T item) {
    synchronized (lock) {
      if (first != null) {
        Node<T> ret = first;
        first = first.next;
        if (first == null) {
          last = null;
        }
        return ret.value;
      }
      return null;
    }
  }
}
