import java.util.NoSuchElementException;

public class SequentialQueue<T> implements Queue<T> {

  // Concrete representation of Queue<T>
  private static final int CAPACITY = 4;
  private T[] store;
  private int front, back;
  private int n;

  public SequentialQueue() {
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[CAPACITY];
    store = temp;
    front = 0;
    back = 0;
    n = 0;
  }

  private void resize(int newSize) {
    @SuppressWarnings("unchecked")
    T[] fresh = (T[]) new Object[newSize];
    for (int i = 0; i < n; i++)
      fresh[i] = store[(front + i) % store.length];
    front = 0;
    back = n;
    store = fresh;
  }

  public void enqueue(T item) {
    if (n == store.length) resize(store.length * 2);
    store[back++] = item;
    if (back == store.length) back = 0;    // wrap
    n++;
  }

  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Queue underflow");
    T item = store[front++];
    if (front == store.length) front = 0;   // wrap
    n--;
    return item;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  @Override
  public String toString() {
    return "stub";
  }

  // Unit testing
  public static void main(String[] args) {
    Queue<Integer> q = new SequentialQueue<Integer>();
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    q.enqueue(7);
    q.dequeue();
    while (!q.isEmpty())
      System.out.format("found queue item %d\n", q.dequeue());
  }
}
