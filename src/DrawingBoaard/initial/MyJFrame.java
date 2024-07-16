package DrawingBoaard.initial;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame
{
    public Shape[] shapeList = null;
    public void paint(Graphics g)
    {
        super.paint(g);
        for(int i = 0;i<shapeList.length;i++)
        {
            Shape shape = shapeList[i];
            if(shape !=null)
            {
                shape.draw(g);
            }
        }
    }

}
