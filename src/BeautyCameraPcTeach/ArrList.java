package BeautyCameraPcTeach;

public class ArrList<E>
{
    //初始数组
    private Object[] arr;
    private static int len = 10;
    private int size = 0;  //记录数据个数

    //构造方法设置初始长度
    public ArrList(int len) {
        arr = new Object[len];
    }

    //设置默认长度为10
    public ArrList() {
        //调用构造方法：this(参数，，);
        this(len);
    }

    //末尾添加数据
    public void add(E data) {
        //判断是否需要扩容
        if (size == arr.length) {
            //对数组扩容
            Object[] nArr = new Object[arr.length *2];
            //复制原数组数据到新数组
            for (int i = 0; i < arr.length; i++) {
                nArr[i] = arr[i];
            }
            //更新对象头
            arr = nArr;
        }
        //按顺序保存数据
        arr[size] = data;
        size++;

    }

    //调价指定位置
    public void add(int index, E data) {
        //判断是否需要扩容
        if (size == arr.length) {
            //对数组扩容
            Object[] nArr = new Object[arr.length *2];
            //复制原数组数据到新数组
            for (int i = 0; i < arr.length; i++) {
                nArr[i] = arr[i];
            }
            //更新对象头
            arr = nArr;
        }
        //index位置后面的数据右移
        for(int i=size-1;i>=index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = data;
        size++;

    }

    //移除指定位置数据
    public E remove(int index) {
        if(index < 0 || index >= size){
            System.out.println("超出访问...");
            return null;
        }
        Object re = arr[index];  //保存被删除数据
        //删除位置后面的数据前移
        for(int i=index;i<size;i++){
            arr[i] = arr[i+1];
        }
        size--;
        return (E)re;
    }

    //移动指定数据
    public boolean removes(E data) {
        for(int i=0;i<size;i++){
            if(data.equals(arr[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }
    //获取数据
    public E get(int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("下标越界...");
            return null;
        }
        return (E)arr[index];
    }

    //动态数组中的数据个数
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrList<String> list = new ArrList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(3,"d");
        list.remove(2);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");

        }
    }
}

