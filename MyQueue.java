package HW9;
import javax.lang.model.element.Element;
import java.util.Stack;

public class MyQueue {
    public Node firstNode;
    public Node lastNode;
    public int size = 0;

    public MyQueue() {
        System.out.println("КОНСТРУКТОР MyQueue()");
    }

    //Класс Node
    private class Node {
        Object item;
        Node nextNode;

        Node(Object item, Node nextNode) {
            this.item = item;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{ " +
                    item +
                    ", " +
                    nextNode +
                    " }";
        }
    }
    // add()
    public boolean add(Object value) {

        Node buffer = lastNode;
        Node node = new Node(value, null);
        lastNode = node;

        if (size == 0) {
            firstNode = node;
            System.out.println("Створили першу ноду");
        } else {
            buffer.nextNode = node;
            System.out.println("Створили наступну ноду");
        }

        size++;
        return (true);
    }
    //remove()
    public Object remove(int index) {
        Object element = null;
        if (index == 0) {
            if (firstNode.nextNode != null) {
                element = firstNode.item;
                firstNode = firstNode.nextNode;
                System.out.println("Deleted first element");
            } else {
                element = firstNode.item;
                firstNode = null;
                lastNode = null;
                System.out.println("Last Node and First Node succesfully deleted !!!!!!!!!");
            }
        } else {
            Node prevNodeToRemove = firstNode;
            for (int i=0; i<(index-1); i++) {
                prevNodeToRemove = prevNodeToRemove.nextNode;
            }
            System.out.println("prevNodeToRemove = " + prevNodeToRemove);
            if (prevNodeToRemove.nextNode.nextNode == null) {
                System.out.println("LAST NODE!!!");
                lastNode = prevNodeToRemove;
                element = prevNodeToRemove.nextNode.item;
                prevNodeToRemove.nextNode = null;
            } else {
                element = prevNodeToRemove.nextNode;
                prevNodeToRemove.nextNode = prevNodeToRemove.nextNode.nextNode;
            }
        }
        size--;
        System.out.println("Удалили");
        return (element);
    }
    //clear()
    public boolean clear() {
        boolean rez = false;

        for (int i = 0; i < size; ) {
            System.out.println("size = " + size);
            remove(0);
        }

        rez = true;
        size = 0;

        return (rez);
    }
    //size()
    public int size() {
        return size;
    }
    //peek()
    public Object peek() {
        return (firstNode.item);
    }
    //poll()
    public Object poll() {
        Object vihlop = firstNode.item;
        remove(0);

        return vihlop;
    }
    //toString()
    @Override
    public String toString() {
        return "MyQueue{ " +
                " firstNode = " + firstNode +
                ", lastNode = " + lastNode +
                ", size = " + size +
                " }";
    }
}