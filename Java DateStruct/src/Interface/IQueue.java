package Interface;

public interface IQueue {
    public void clear();
    public boolean isEmpty();
    public int length();
    public Object peek();
    public void offer(Object value) throws Exception;
    public Object poll();
    public void display();
}
