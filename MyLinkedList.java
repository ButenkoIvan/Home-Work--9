package HW9;
public class MyLinkedList {
    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public MyLinkedList() {
        lastNode = new Node(firstNode, null, null);
        firstNode = new Node(null, null, lastNode);
    }

    // Класс Node
    private static class Node {

        private Node prevNode;
        private Object item;
        private Node nextNode;

        Node(Node prevNode, Object item, Node nextNode) {
            this.prevNode = prevNode;
            this.item = item;
            this.nextNode = nextNode;
        }
        public Node getPrevNode() {
            return prevNode;
        }
        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }
        public Object getItem() {
            return item;
        }
        public void setItem(Object item) {
            this.item = item;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", item=" + item +
                    '}';
        }
    }
    //  Метод add()
    public boolean add(Object o) {
        boolean rez = false;
        Node prevNode = lastNode;
        prevNode.setItem(o);
        lastNode = new Node(prevNode, null, null);
        prevNode.setNextNode(lastNode);
        size++;
        rez = true;
        return rez;
    }
    //метод remove()
    public boolean remove(int index) {
        boolean rez = false;

        Node nodeToRemove = null;
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        } else {
            if (index == 0) {
                firstNode = firstNode.getNextNode();
                size--;
                return true;
            }
            nodeToRemove = firstNode;
            for(int i=0; i <= index; i++) {
                nodeToRemove = nodeToRemove.getNextNode();
            }
            nodeToRemove.getNextNode().setPrevNode(nodeToRemove.getPrevNode());
            nodeToRemove.getPrevNode().setNextNode(nodeToRemove.getNextNode());
            nodeToRemove = null;
        }
        size --;
        rez = true;
        return rez;
    }
    //метод clear()
    public void clear() {

        this.lastNode = new Node(firstNode, null, null);
        this.firstNode = new Node(null, null, lastNode);
        this.size = 0;
    }
    // метод size()
    public int size() {
        return (size);
    }
// метод get()

    public Object get(int index) {
        Node vihlop = firstNode.getNextNode();
        for (int i=0; i<index; i++) {
            vihlop = vihlop.getNextNode();
        }
        return vihlop.getItem();
    }
//метод toString()

    @Override
    public String toString() {
        String S = "[ ";

        if (this == null) {
            S = "null";
        }

        for(int i=0; i<this.size(); i++) {
            S += this.get(i) + " ";
        }
        return (S.trim() + " ]");
    }
}
