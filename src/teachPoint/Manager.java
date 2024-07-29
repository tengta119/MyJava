package teachPoint;
public class Manager
{
    public void showPoint(Line l1)
    {
        l1.show();
    }
    public void showLine(Point p1)
    {
        p1.show();
    }

    public static void main(String []args)
    {
        Point p1 = new Point(1,2,3,4);
        Line l1 = new Line(5,6,7,8);
        Manager my = new Manager();
        my.showLine(p1);
        my.showPoint(l1);
    }
}
