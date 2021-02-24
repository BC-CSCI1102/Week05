import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

  private Node front, back;
  private int n;

  private class Node {
    T info;
    Node next;

    private Node(T info, Node next) {
      this.info = info;
      this.next = next;
    }
  }

  public LinkedQueue() {
    front = null;
    back = null;
    n = 0;
  }

  public void enqueue(T item) {
    Node newBack = new Node(item, null);
    if (back == null)
      front = newBack;
    else
      back.next = newBack;
    back = newBack;
    n++;
  }

  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Empty queue");

    T answer = front.info;
    front = front.next;
    if (front == null) back = null;
    n--;
    return answer;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public static void main(String[] args) {

    // Simple unit testing
    Queue<String> queue = new LinkedQueue<String>();

    queue.enqueue("California");
    queue.enqueue("Arizona");
    queue.enqueue("Nevada");

    while (!queue.isEmpty())
      System.out.format("%s\n", queue.dequeue());
  }
}

