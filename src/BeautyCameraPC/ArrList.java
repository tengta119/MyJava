package BeautyCameraPC;

public class ArrList<E>
{
    private Object[] arr;
    private int len;
    private int length;

    ArrList()
    {
        this.len=10;
        arr=new Object[10];
    }
    ArrList(int len)
    {
        this.len=len;
        arr= new Object[this.len];
    }
    //末尾添加数据
    public void add(E data)
    {
        if(length==arr.length)
        {
            Object[] nArr = new Object[arr.length*2];
            for(int i=0 ; i< arr.length ; i++)
                nArr[i]=arr[i];
            arr=nArr;
        }
        arr[length++]=data;
    }
    //插入指定位置
    public void add(int index,E data)
    {
        if(length==arr.length)
        {
            Object[] nArr = new Object[arr.length*2];
            for(int i=0 ; i< arr.length ; i++)
                nArr[i]=arr[i];
            arr=nArr;
        }
        for(int i=index ; i>=0 ; i--)
        {
            arr[i+1]=arr[i];
        }
        arr[index]=data;
    }

    //移除指定位置数据
    public void remove(int index)
    {
        int temp=0;
        Object[] nArr = new Object[arr.length];
        for(int i=0 ; i<index ; i++)
            nArr[i]=arr[i];
        temp = index;
        for(int i=index+1 ; i< arr.length ; i++)
            nArr[temp++]=arr[i];
        arr=nArr;
        length-=1;
    }

    //移动指定数据
    public void removes(E data)
    {
        Object[] nArr = new Object[arr.length-1];
        int i=0;
        for(Object n :arr)
        {
            if(n==data) break;
            nArr[i++] = n;
        }
        for(int j=i ; j<arr.length ; j++)
            nArr[i++]=arr[j];
        arr=nArr;
        length-=1;
    }

    //获取数据
    public E get(int index)
    {
        return (E)arr[index];
    }

    //动态数组中的数据个数
    public int size()
    {
        return length;
    }

//    public static void main(String[] args)
//    {
//        ArrList list = new ArrList();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.remove(1);
//
//        for(int i=0;i<list.size();i++)
//        {
//            System.out.println(list.get(i));
//        }
//    }
}
