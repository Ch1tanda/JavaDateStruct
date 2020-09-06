package Queue;

import Interface.IQueue;

public class CircleSqQueue implements IQueue {
    private Object[] data;
    private int front;
    private int rear;
    private int maxSize;

    public CircleSqQueue(int maxSize) {
        this.data = new Object[maxSize];
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
    }

    @Override
    public void clear() {
        this.front = this.rear;
    }

    @Override
    public boolean isEmpty() {
        return this.rear == this.front ? true : false;
    }

    @Override
    public int length() {
        return (this.rear - this.front + this.maxSize) % this.maxSize;
    }

    @Override
    public Object peek() {
        return this.data[this.front];
    }

    @Override
    public void offer(Object value) throws Exception {
        if ((this.rear + 1) % maxSize == this.front) {
            throw new Exception("队列已满，无法插入");
        } else {
            this.data[this.rear] = value;
            this.rear = (this.rear + 1) % this.maxSize;
        }
    }

    @Override
    public Object poll() {
        if (this.rear == this.front) {
            return null;
        } else {
            Object value =  this.data[this.front];
            this.front = (this.front + 1) % this.maxSize;
            return value;
        }
    }

    @Override
    public void display() {
        if(!isEmpty()){
            for(int i=this.front;(this.rear-i+maxSize)%maxSize>0;i=(i+1)%maxSize){
                System.out.print(this.data[i]+" ");
            }
        }
    }
    public  static  void main(String[] args) throws Exception {
        CircleSqQueue test = new CircleSqQueue(6);
        test.offer(5);
        test.offer(6);
        test.offer(7);
        test.offer(7);
        test.offer(7);
        test.poll();
        test.offer(5);
        test.poll();
        test.offer(6);
        test.display();
    }
}
