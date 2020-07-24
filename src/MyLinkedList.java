/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-07-25
 * Time:6:33
 **/
class Node {
    private Node next;
    private int data;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class MyLinkedList {
    public Node head;

    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            head = node;
            return;
        }
        Node cur = this.head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    public Node reverse(){
    Node newHead = null;
    Node prev = null;
    Node cur = this.head;
    while(cur != null){
        Node curNext = cur.getNext();
        if (curNext == null){
            newHead = cur;
        }
        cur.setNext(prev);
        prev = cur;
        cur = curNext;

    }
    return newHead;
    }
    public Node findPrev(int key){
        Node prev = this.head;
        while(prev.getNext() != null){
            if (prev.getNext().getData() == key){
                return prev;
            }
            prev = prev.getNext();
        }
        return null;
    }
    public void remove(int key){
        if (this.head == null){
            return;
        }

        if (this.head.getData() == key){
            this.head = this.head.getNext();
            return;
        }
        Node prev = findPrev(key);
        if (prev == null){
            return;
        }
        Node del = prev.getNext();
        prev.setNext(del.getNext());

    }
    public void display2(Node newHead){
        Node cur = newHead;
        while (cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
    }
    public Node middle(){
        Node slow = this.head;
        Node fast = this.head;
        while(fast != null  && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    public Node find(int k){
        if (this.head == null){
            return null;
        }

        Node slow = this.head;
        Node fast = this.head;
        while(k-1 > 0){
            fast = fast.getNext();
        }
        fast = fast.getNext();
        slow = slow.getNext();
        return slow;
    }
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }

    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
        myLinkedList.addLast(50);
        myLinkedList.display();
        System.out.println();
        /*Node ret = myLinkedList.reverse();
        myLinkedList.display2(ret);
        System.out.println();*/
       /* myLinkedList.remove(20);
        myLinkedList.display();*/
       Node ret = myLinkedList.middle();
        System.out.println(ret.getData());

        /*Node ret = myLinkedList.reverse();
        myLinkedList.display2(ret);*/
    }
}
