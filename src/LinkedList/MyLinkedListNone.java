package LinkedList;

public class MyLinkedListNone<E> {

    private Node head;
    private int numNodes;
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
    public MyLinkedListNone() {
    }

    public MyLinkedListNone(Object data) {
        this.head = new Node(data);
        numNodes++;
    }

    public void add(int index, E data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Node Size: " + numNodes);
        }
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;

    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E data) {
        if (numNodes == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;

    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Node Size: " + numNodes);
        }
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next.next;
        temp.next = holder;
        numNodes--;
        return (E) temp.next;
    }

    public boolean remove(Object e) {
        Node temp = head;
        Node holder;
        if (e == null) {
            for (int i = 0; i < numNodes; i++) {
                holder = temp.next.next;
                if (temp.next == null) {
                    temp.next = holder;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        for (int i = 0; i < numNodes; i++) {
            holder = temp.next.next;
            if (e.equals(temp.next.getData())) {
                temp.next = holder;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }

        return true;
    }

    public E get(int index) {
        Node temp = head;
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Node: " + numNodes);
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public int size() {
        return this.numNodes;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    @Override
    public MyLinkedListNone clone() {
        MyLinkedListNone<E> cloneList = new MyLinkedListNone();
        cloneList.head = head;
        cloneList.numNodes = numNodes;
        return cloneList;
    }

    public boolean contains(E o) {
        return indexOf(o) > 0;
    }

    public int indexOf(E o) {
        Node temp = head;
        if (o == null) {
            for (int i = 0; i < numNodes; i++) {
                if (temp.getData() == null) {
                    return i;
                }
                temp = temp.next;
            }
        }
        for (int i = 0; i < numNodes; i++) {
            if (o.equals(temp.getData())) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
}
