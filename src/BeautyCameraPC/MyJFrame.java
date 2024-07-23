package BeautyCameraPC;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame
{
    Image[] images=null;
    int num=0;
    Graphics g;
    public void paint(Graphics g)
    {
        super.paint(g);
        for(int i=0 ; i<images.length ; i++)
        {
            images[i].show();
        }
    };

}
