package LinearList;

import Interface.IList;

import java.util.Scanner;

public class LinkedList implements IList {
    public Node head;

    public class Node {
        public Object data;
        public Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList() {
        this.head = new Node();
    }

    public LinkedList(int n, boolean Order) throws Exception {
        this();
        if (Order) {
            create1(n);
        } else create2(n);
    }

    public void create1(int n) throws Exception { //头插法
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(0,scanner.next());
        }
    }

    public void create2(int n) throws Exception{ //尾插法
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<n;i++){
            insert(i,scanner.next());
        }
    }

    @Override
    public void clear() {
        this.head.next = null;
    }

    @Override
    public boolean isEmpty() {
        if (this.head.next == null) {
            return true;
        } else return false;
    }

    @Override
    public int length() {
        int length = 0;
        Node p = this.head;
        while (p.next != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    @Override
    public Object get(int position) throws Exception {
        Node p = head;
        int j;
        for (j = -1; j < position && p != null; j++) {   //获得目标结点
            p = p.next;
        }
        if (j > position || p == null) {
            throw new Exception("第" + position + "个元素不存在");
        } else return p.data;
    }

    @Override
    public void insert(int position, Object value) throws Exception {
        Node p = head;
        int j;
        for (j = -1; j < position - 1 && p != null; j++) {
            p = p.next;
        }
        if(j>position-1||p==null){
            throw new Exception("插入位置非法");
        }else{
            Node newNode = new Node(value);
            newNode.next=p.next;
            p.next=newNode;
        }

    }

    @Override
    public void remove(int position) throws Exception {
        Node p = this.head;
        int j;
        for(j=-1;j<position-1&&p!=null;j++){
            p=p.next;
        }
        if(j>position-1||p==null){
            throw new Exception("移除位置不合法");
        }else{
            p.next = p.next.next;
        }

    }

    @Override
    public int indexOf(Object value) {
        Node p = head.next;
        int i=0;
        while(p!=null){
            if(p.data==value){
                return i;
            }else{
                i++;
                p=p.next;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        Node p = head.next;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList aLinkedList = new LinkedList(10,true);
        aLinkedList.remove(0);
        aLinkedList.insert(0,777);
        aLinkedList.display();
    }
}
