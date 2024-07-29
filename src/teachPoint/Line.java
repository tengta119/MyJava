package teachPoint;

public class Line extends Point
{
    Line(int x1, int y1,int x2,int y2)
    {
        super(x1,y1,x2,y2);
    }
    public double distance()
    {
        return Math.sqrt(Math.pow(getX1()-getX2(),2)+Math.pow(getY1()-getY2(),2));
    }
    public void show()
    {
        System.out.println("x1="+getX1()+"x2="+getX2()+"y1="+getY1()+"y2="+getY2());
        System.out.println("distance"+distance());
    }
}
