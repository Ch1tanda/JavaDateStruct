package Queue;

import Interface.IQueue;

public class LinkedQueue implements IQueue {
    public Node rear;
    public Node front;
    public class Node{
        Object data;
        Node next;
        public Node(Object value){
            this.data = value;
        }
    }
    @Override
    public void clear() {
        rear = front = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        int length=0;
        Node p = front;
        while(p!=null){
            length++;
            p=p.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            return null;
        }else return front.data;
    }

    @Override
    public void offer(Object value) throws Exception {
        Node newNode = new Node(value);
        if(isEmpty()){
            newNode.next=null;
            front = rear = newNode;
        }else{
            newNode.next = rear.next;
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    public Object poll() {
        if(isEmpty()){
            return null;
        }else{
            Object value = front.data;
            if(rear==front){
                clear();
            }else{
                front= front.next; 
            }
            return value;
        }
    }

    @Override
    public void display() {
        Node p = front;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
    }
    public static void main(String[] args) throws Exception {
        LinkedQueue test = new LinkedQueue();
        test.offer(1);
        test.offer(1);
        test.offer(1);
        test.offer(1);
        test.offer(1);
        test.offer(1);
        test.display();
    }
}
