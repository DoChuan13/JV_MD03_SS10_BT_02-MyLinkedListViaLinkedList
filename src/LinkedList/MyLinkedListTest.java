package LinkedList;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        myLinkedList.addLast("Pre First Element");
        myLinkedList.add(0, "22");
        myLinkedList.add(0, "88");
        myLinkedList.add(1, "90");
        myLinkedList.addLast("Finish");
        myLinkedList.addFirst("First");
        System.out.println("Linked List size first time: " + myLinkedList.size());
        System.out.println("First Test Linked List =>>");
        myLinkedList.printList();
        System.out.println("------------------------------------\n");
        myLinkedList.addFirst("12");
        myLinkedList.add(1, "13");
        myLinkedList.add(3, "66");
        myLinkedList.addLast("Finish 002 = 008");
        System.out.println("Linked List size second time: " + myLinkedList.size());
        System.out.println("Second Test Linked List =>>");
        myLinkedList.printList();
        System.out.println("Data at index 8: " + myLinkedList.get(8));
        System.out.println("------------------------------------\n");
        myLinkedList.remove(2);
        myLinkedList.remove("13");
        System.out.println("Linked List size third time: " + myLinkedList.size());
        System.out.println("Third Test Linked List =>>");
        myLinkedList.printList();
        System.out.println("------------------------------------\n");
        System.out.println("Index of 88: " + myLinkedList.indexOf("88"));
        System.out.println("------------------------------------\n");
        myLinkedList.add(2, "00");
        myLinkedList.addFirst("33");
        System.out.println("Linked List size: " + myLinkedList.size());
        myLinkedList.remove(6);
        System.out.println("Linked List size: " + myLinkedList.size());
        myLinkedList.printList();
        System.out.println("------------------------------------\n");
        System.out.println("Linked List size third time: " + myLinkedList.size());
        System.out.println("Four Test Linked List =>>");
        myLinkedList.printList();
        System.out.println("------------------------------------\n");
    }

}
