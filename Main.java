package HW9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] organs) throws IOException {
        LinkedList list = new LinkedList<>();
        MyLinkedList myLinkedList = new MyLinkedList();
        //add()
        myLinkedList.add("One");
        myLinkedList.add("Two");
        myLinkedList.add("Three");
        myLinkedList.add("Four");
        myLinkedList.add("Five");
        myLinkedList.add("Six");
        System.out.println("myLinkedList = " + myLinkedList);
        //remove()
        myLinkedList.remove(0);
        System.out.println("myLinkedList after remove 0 = " + myLinkedList);
        // size()
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        //get()
        System.out.println("myLinkedList.get(0) = " + myLinkedList.get(0));
        System.out.println("myLinkedList.get(4) = " + myLinkedList.get(4));
        System.out.println("myLinkedList.get(3) = " + myLinkedList.get(3));
        //clear()
        myLinkedList.clear();
        System.out.println("myLinkedList after clear() = " + myLinkedList);
    }
}
