package Stack;

import Interface.IStack;

public class LinkedStack implements IStack {
    public class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    private Node top;

    public LinkedStack(){
        this.top=null;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null ? true : false;
    }

    @Override
    public int length() {
        int length = 0;
        Node head = top;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        return this.top.data;
    }

    @Override
    public void push(Object x) throws Exception {
        Node newNode = new Node(x);
        newNode.next = this.top;
        this.top = newNode;
    }

    @Override
    public Object pop() {
        if(this.top==null){
            return null;
        }else{
            Object value = top.data;
            top = top.next;
            return value;
        }
    }

    @Override
    public void display() {
        Node head = this.top;
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        LinkedStack aLinkedStack = new LinkedStack();
        aLinkedStack.push(3);
        aLinkedStack.push(4);
        aLinkedStack.push(5);
        aLinkedStack.display();
        aLinkedStack.pop();
        aLinkedStack.display();
    }
}
