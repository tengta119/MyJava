package DrawingBoaard.v2;
import java.awt.*;

public class MyArrayList
{
    Point[] value;
    int length;
    int size;

    public MyArrayList()
    {
        int length = 10;
        value = new Point[length];
    }

    public void add(Point newPoint)
    {
        if(size == length)
        {
            int oldLength = length;
            int newLength = oldLength + (oldLength>>1);
            Point[] newValue = new Point[newLength];
            if (length >= 0)
            {
                System.arraycopy(value, 0, newValue, 0, length);
            }
            value = newValue;
            length = newLength;
        }
        value[size++] = newPoint;

    }


}
