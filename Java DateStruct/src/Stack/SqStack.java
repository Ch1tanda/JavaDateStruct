package Stack;

import Interface.IStack;

import java.util.Queue;

public class SqStack implements IStack {
    Object[] data;
    int top;
    int maxSize;

    public SqStack(int maxSize) {
        this.top = 0;
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
    }

    @Override
    public void clear() {
        this.top = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.top==0?true:false;
    }

    @Override
    public int length() {
        return this.top;
    }

    @Override
    public Object peek() {
        return this.data[this.top-1];
    }

    @Override
    public void push(Object x) throws Exception{
        if(this.top==this.maxSize){
            throw new Exception("栈已满，无法push");
        }else{
            this.data[this.top++] = x;
        }
    }

    @Override
    public Object pop() {
        if(isEmpty()){
            return null;
        }else{
            this.top--;
            return this.data[this.top];
        }
    }

    @Override
    public void display() {
        for(int i=this.top-1;i>=0;i--){
            System.out.print(this.data[i]+" ");
        }
    }

    public void isMatched(String str) throws Exception{
        char[] charArray = str.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='('){
                this.push(charArray[i]);
            }else if(charArray[i]==')'&&!isEmpty()){
                pop();
            }else if(charArray[i]==')'&&isEmpty()){
                System.out.print("括号不匹配");
                return ;
            }
        }
        if(isEmpty()){
            System.out.print("括号匹配");
        }else{
            System.out.print("括号不匹配");
        }
    }

    public void EnQueue(SqStack A, SqStack B,Object value) throws Exception {
        B.push(value);
    }

    public Object DeQueue(SqStack A,SqStack B) throws Exception {
         if(A.isEmpty()){
             while(!B.isEmpty()){
                 A.push(B.pop());
             }
             return A.pop();
         }else{
             return A.pop();
         }
    }

    public static void main(String[] args) throws Exception {
        SqStack A = new SqStack(10);
        SqStack B = new SqStack(10);
        SqStack Queue = new SqStack(20);
        Queue.EnQueue(A,B,1);
        Queue.EnQueue(A,B,2);
        System.out.print(Queue.DeQueue(A,B));
        Queue.EnQueue(A,B,3);
    }
}
