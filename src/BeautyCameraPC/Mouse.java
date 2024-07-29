package BeautyCameraPC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mouse implements MouseListener, ActionListener
{

    public Mouse(Graphics g){System.out.println("construction method");}
    public Mouse(){System.out.println("Default construction method");}
    String path = "D:\\Jave\\1.png";
    Graphics g;
    int num=0;
    public  Image[] images=new Image[100];
    private BufferedImage[] bufferedImages = new BufferedImage[1];

    public BufferedImage[] getBufferedImages()
    {
        System.out.println("MouseGetBufferedImages");
        return bufferedImages;
    }
    public void withDraw()
    {
       images[num-1].show();
    }
    public void setG(Graphics g)
    {
        this.g = g;
    }

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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("撤回"))
        {
            images[--num].show();
            return;
        }
        Image image = new Image(path,e.getActionCommand(),g);
        image.show();
        images[num++]=image;
        if(num>100)
            num=0;


    }
}
