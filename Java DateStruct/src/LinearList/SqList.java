package LinearList;

import Interface.*;

public class SqList implements IList {
    private Object[] listItem;
    private int length;
    private int maxSize;

    public SqList(int maxSize) {
        this.length = 0;
        this.maxSize = maxSize;
        this.listItem = new Object[maxSize];
    }

    @Override
    public void clear() {
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        } else return false;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public Object get(int position) {
        int i = 0;
        while (i < position) i++;
        return listItem[i];
    }

    @Override
    public void insert(int position, Object value) throws Exception {
        if (this.length == this.maxSize) {
            throw new Exception("顺序表已满，无法插入");
        } else if(position<0||position>this.length){
            throw new Exception("插入位置非法");
        }else{
            for(int i=this.length-1;i>=position;i--){
                this.listItem[i+1]=this.listItem[i];
            }
            this.length++;
            this.listItem[position]=value;
        }
    }

    @Override
    public void remove(int position) throws Exception{
        if(position<0||position>=this.length){
            throw new Exception("删除位置非法");
        }else{
            for(int i=position;i<this.length-1;i++){
                this.listItem[i]=this.listItem[i+1];
            }
            this.length--;
        }
    }

    @Override
    public int indexOf(Object value) {
        for(int i=0;i<this.length;i++) {
            if (this.listItem[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        for(int i=0;i<this.length;i++)
        System.out.print(this.listItem[i]+" ");
    }

    public static void main(String[] args) throws Exception {
        SqList aSqList = new SqList(5);
        aSqList.insert(0,1);
        aSqList.insert(1,2);
        aSqList.display();
    }
}
