package LinearList;

import Interface.IList;

import java.util.Scanner;

public class DoubleLinkedList implements IList {
    DuNode head;

    public DoubleLinkedList() {
        this.head = new DuNode();
    }

    public class DuNode {
        public Object data;
        public DuNode prior;
        public DuNode next;

        public DuNode() {
            this.prior = null;
            this.next = null;
        }

        public DuNode(Object data) {
            this.data = data;
            this.prior = null;
            this.next = null;
        }

        public DuNode(Object data, DuNode prior, DuNode next) {
            this.data = data;
            this.prior = prior;
            this.next = next;
        }
    }

    public DoubleLinkedList(int n , Boolean Order) throws Exception{
        this();
        Scanner scanner = new Scanner(System.in);
        if(Order){
            for(int i=0;i<n;i++){
                insert(0,scanner.next());
            }
        }else{
            for(int i=0;i<n;i++){
                insert(i,scanner.next());
            }
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
        int length = 0;     //要初始化
        DuNode p = this.head;
        while (p.next != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    @Override
    public Object get(int position) throws Exception {
        DuNode p = this.head.next;
        int j;
        for (j = 0; j < position && p != null; j++) {
            p = p.next;
        }
        if (j > position || p == null) {
            throw new Exception("位置不合法");
        } else {
            return p.data;
        }
    }

    @Override
    public void insert(int position, Object value) throws Exception { //要判断位置如果是最后 情况不同
        DuNode p = this.head;
        int j;
        for (j = -1; j < position - 1 && p != null; j++) {
            p = p.next;
        }
        if (j > position - 1 || p == null) {
            throw new Exception("插入位置不合法");
        } else {
            DuNode newNode = new DuNode(value);
            if(p.next==null){
                newNode.next= p.next;
                newNode.prior =p;
                p.next=newNode;
            }else{
                newNode.next = p.next;
                p.next.prior = newNode;
                newNode.prior = p;
                p.next = newNode;
            }
        }
    }

    @Override
    public void remove(int position) throws Exception {
        DuNode p = this.head;
        int j;
        for (j = -1; j < position; j++) {
            p = p.next;
        }
        if (j > position || p == null) {
            throw new Exception("移除位置不合法");
        } else {
            if(p.next!=null){
                p.prior.next=p.next;
                p.next.prior=p.prior;
            }else{
                p.prior.next=p.next;
            }
        }
    }

    @Override
    public int indexOf(Object value) {
        int index=0;
        DuNode p = head.next;
        while(p!=null){
            if(p.data == value){
                return index;
            }else{
                index++;
                p=p.next;
            }

        }
        return -1;
    }

    @Override
    public void display() {
        DuNode p = head.next;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
    }

    public static void main(String[] args) throws Exception {
        DoubleLinkedList aDoubleLinkedList = new DoubleLinkedList(5,false);
        aDoubleLinkedList.remove(4);
        aDoubleLinkedList.display();
    }
}
