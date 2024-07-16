package DrawingBoaard.initial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawFun implements MouseListener, ActionListener
{
    public Graphics g = null;
    int x1 = 0,y1 = 0,x2 = 0,y2 = 0,x3=0,y3=0;
    int x11,y11,x22,y22,x33,y33;
    int count = 0;
    String type = " ";
    Shape[] myshape = new Shape[100];
    int i = 0 ;
    Color color1 = null;

    public void setG(Graphics g )
    {
        this.g = g;
    }

    public int abs(int a )
    {
        return a < 0 ? -a : a;
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals(" "))
        {
            JButton btn = (JButton) e.getSource();
             color1 = btn.getBackground();
            g.setColor(color1);
        }
        else
        {
            type = e.getActionCommand();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

        int x = e.getX();
        int y = e.getY();
        if(type.equals("三角形"))
        {

            if (count == 0)
            {
                x11 = x;
                y11 = y;
                count++;

            }
            else if (count == 1)
            {
                x22 = x;
                y22 = y;
                Shape shape = new Shape("直线",x11,y11,x22,y22,color1);
                shape.draw(g);
                myshape[i++] = shape;
                count++;

            }
            else if(count==2)
            {
                x33 = x;
                y33 = y;
                Shape shape = new Shape("直线",x22,y22,x33,y33,color1);
                shape.draw(g);
                myshape[i++] = shape;
                Shape shape1 = new Shape("直线",x11,y11,x33,y33,color1);
                shape1.draw(g);
                myshape[i++] = shape1;
                count = 0;

            }

        }
        else if(type.equals("多边形"))
        {
            if(count == 0 )
            {
                x11 = x;
                y11 = y;
                count++;
            }
             else if(count == 1 )
            {
                x22 = x;
                y22 = y;
                Shape shape = new Shape("直线",x11,y11,x22,y22,color1);
                shape.draw(g);
                myshape[i++] = shape;
                count++;

            }
             else if(count == 2)
            {
                x33 = x;
                y33 = y;
                Shape shape1 = new Shape("直线",x22,y22,x33,y33,color1);
                shape1.draw(g);
                myshape[i++] = shape1;
                x22 = x33;
                y22 = y33;
                if(Math.abs(x11-x33)<10 && Math.abs(y11-y33)<10)
                {
                    Shape shape3 = new Shape("直线",x11,y11,x33,y33,color1);
                    shape3.draw(g);
                    myshape[i++] = shape3;
                    count=0;
                }
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
            int x = e.getX();
            int y = e.getY();
            x1 = x;
            y1 = y;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        x2 = x;
        y2 = y;

        Shape shape = new Shape(type,x1,y2,x2,y2,color1);
        shape.draw(g);
        myshape[i++] = shape;



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
