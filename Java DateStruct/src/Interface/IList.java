package Interface;

public interface IList {
    public void clear();//将线性表置空
    public boolean isEmpty();//判断线性表是否为空
    public int length();//获取线性表的长度
    public Object get(int position) throws Exception;//获取第position个元素的值（下标从0开始）
    public void insert(int position,Object value) throws Exception;//将value插入第position个位置
    public void remove(int position) throws Exception;//移除第position位置的元素
    public int indexOf(Object value);//返回值为value首次出现的下标值
    public void display();//输出线性表中各个值
}
