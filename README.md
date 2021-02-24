# CSCI 1102 Computer Science 2

### Spring 2021

------

## Lecture Notes

### Week 5: Queues & Memory Organization

#### Topics:

1. Sequential & Linked Implementations of Queues
2. Double-Ended Queues
3. Memory Organization
---

## 1. Circular-Array Implementations of Queues

Remember the Queue ADT

```java
public interface Queue<Item> {
  void enqueue(Item item);
  Item dequeue();
  boolean isEmpty();
  int size();
  String toString();
}
```

For a sequential implementation, the front of the queue "chases" the back of the queue

```
enqueue(A); enqueue(B); enqueue(C); enqueue(D);
+---+---+---+---+---+ 
| A | B | C | D |   |
+---+---+---+---+---+
  ^               ^
  |               |
front            back

dequeue(); dequeue(); dequeue();
+---+---+---+---+---+ 
| - | - | - | D |   |
+---+---+---+---+---+
              ^   ^
              |   |
           front back
```

To avoid wasting the space with the `-`s, we loop back around. 

```
enqueue(E); enqueue(F) 
+---+---+---+---+---+ 
| F | - | - | D | E |
+---+---+---+---+---+
      ^       ^
      |       |
     back   front
```

The key function is the (linear-cost) `resize` operation:

```java
private void resize(int capacity) {
  Item[] temp = (Item[]) new Object[capacity];
  for (int i = 0; i < n; i++)
    temp[i] = q[(first + i) % q.length];
  q = temp;
  first = 0;
  last  = n;
}
```

## 2. Double-Ended Queues (Deques — pronounced "decks")

Additions and removals from both left and right.

```java
public interface Deque<T> {
  void pushLeft(T item);
  T popLeft();
  void pushRight(T item);
  T popRight();
  int size();
  boolean isEmpty();
  String toString();
}
```

Data structure implementation by **composition**. Very important.

```java
public class StackC<Item> implements Stack<Item> {
    private Deque<Item> stack;
    public StackC() {
      stack = new DoublyLinkedDeque<Item>();
    }
    public void push(Item info) { stack.pushLeft(info); }
    public Item pop() { return stack.popLeft(); }
    public boolean isEmpty() { return stack.isEmpty(); }
    public int size() { return stack.size(); }
}
```

```java
public class QueueC<Item> implements Queue<Item> {
    private Deque<Item> queue;
    public QueueC() {
        queue = new DoublyLinkedDeque<Item>();
    }
    public void enqueue(Item info) { queue.pushLeft(info); }
    public Item dequeue() { return queue.popRight(); }
    ...
}
```

Implementation of Deques can be sequential or linked. Linked implementations are **doubly linked**:

```

+----------+------+------------+
| previous | info |    next    |
+----------+------+------------+

         +-----+-----+-----+         +-----+-----+-----+
    <----+--o  |     |     | <-------+--o  |     |     |
         |     |  A  |     |         |     |  B  |     |
         |     |     |  o--+-------->|     |     |  o--+----->
         +-----+-----+-----+         +-----+-----+-----+
         
```


