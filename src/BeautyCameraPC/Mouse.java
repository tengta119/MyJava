package BeautyCameraPC;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener
{
    private Graphics g;
    public Mouse(Graphics g){this.g=g;System.out.println("construction method");}
    public Mouse(){System.out.println("Default construction method");}

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("click");
        int x=e.getX();
        int y=e.getY();
        System.out.println("x="+x+" "+"y="+y);

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
