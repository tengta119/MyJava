package BeautyCameraPC;

public class LinkList
{
    //定义root 用来保存链表的head 节点
    private Node root ;
    private Node last; //记录尾节点
    private int size=0 ; //记录数据个数

    public LinkList()
    {
        root = new Node();
    }

    //添加
    public void add(int data)
    {
        //创建节点保存数据
        Node node = new Node(data);

        //取出头节点
        Node head = root.next;
        if(head == null){
            //把node 保存为头节点
            root.next = node;
            last = node;
        }else
        {
            //遍历到最后一节点
            //保存尾节点
            last.next = node;
            //尾节点后移
            last = node;
        }
        size++;
    }

    //获取数据
    public int get(int index)
    {
        Node p = root.next;
        for(int i=0 ; i<index ; i++)
        {
            p=p.next;
        }
        return p.data;

    }

    //返回长度
    public int size(){
        return 0;
    }

}

//定义节点类
class Node
{
    public int data;  //保存数据
    public Node next;  //保存下一个节点对象

    public Node(int data)
    {
        this.data = data;
    }
    public Node()
    {

    }

}
