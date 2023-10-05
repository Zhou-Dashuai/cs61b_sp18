public class LinkedListDeque<T> {
    public class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentFront.next.
    * The last item is at sentBack.next.
    * */
    private IntNode sentFront;
    private int size;
    private IntNode sentBack;

    /* Adds an item of type `T` to the front of the deque.*/
    public void addFirst(T item) {
        sentFront.next = new IntNode(sentFront,item, sentFront.next);
        sentFront.next.next.prev = sentFront.next;
        size += 1;
    }

    /* Adds an item of type `T` to the back of the deque. */
    public void addLast(T item) {
      sentBack.prev.next  = new IntNode(sentBack.prev, item, sentBack);
      sentBack.prev = sentBack.prev.next;
      size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return sentFront.next == sentBack;

    }

    /* Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque() {
        if (isEmpty()) {

        } else {
            IntNode p = sentFront.next;
            System.out.print(p.item);
            while (p.next != sentBack) {
                p = p.next;
                System.out.print(" "+p.item);
            }
        }
    }

    /* Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }else {
            T temp = sentFront.next.item;
            sentFront.next = sentFront.next.next;
            sentFront.next.prev = sentFront;
            size -= 1;
            return temp;
        }
    }

    /* Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
    */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }else {
            T temp = sentBack.prev.item;
            sentBack.prev = sentBack.prev.prev;
            sentBack.prev.next = sentBack;
            size -= 1;
            return temp;
        }
    }

    /*Gets the item at the given index,
      where 0 is the front, 1 is the next item, and so forth.
     If no such item exists, returns null. Must not alter the deque!
      */
    public T get(int index) {
        if (isEmpty() && index > size - 1) {
            return null;
        }
        IntNode p = sentFront.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public LinkedListDeque() {
        sentFront = new IntNode(null,null,null);
        sentBack = new IntNode(null,null,null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }

    public T getRecursiveHelper(IntNode p, int i) {
        if (i == 0) {
            return p.item;
        }
        p = p.next;
        return getRecursiveHelper(p, i - 1);
    }

    public T getRecursive(int index) {
        if (isEmpty() && index > size - 1) {
            return null;
        }
        IntNode p = sentFront.next;
        return getRecursiveHelper(p, index);
    }
}



