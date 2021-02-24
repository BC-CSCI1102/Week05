// An API for a simple queue data structure
//
public interface Queue<Item> {

  void enqueue(Item item);

  Item dequeue();

  boolean isEmpty();

  int size();

  @Override
  String toString();
}

