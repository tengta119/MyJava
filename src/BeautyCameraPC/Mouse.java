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
    public ArrList<Image> imageList = new ArrList();
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
            imageList.remove(--num);
            Image image =imageList.get(--num);
            image.show();
//            images[--num]=null;
//            images[--num].show();
            return;
        }
        if(e.getActionCommand().equals("右转"))
        {
//            int[][]arrRight = images[num-1].getArr();
//            int[][]arrRightN = new int[arrRight[0].length][arrRight.length];
//            for(int i=0 ; i<arrRight.length ; i++)
//            {
//                for(int j=0 ; j<arrRight[0].length ; j++)
//                {
//                    arrRightN[j][arrRight.length-1-i] = arrRight[i][j];
//                }
//            }
//
//            images[num-1].setArr(arrRightN);
//            images[num-1].show();
            int[][]arrRight = (imageList.get(num-1)).getArr();
            int[][]arrRightN = new int[arrRight[0].length][arrRight.length];
            for(int i=0 ; i<arrRight.length ; i++)
            {
                for(int j=0 ; j<arrRight[0].length ; j++)
                {
                    arrRightN[j][arrRight.length-1-i] = arrRight[i][j];
                }
            }

            (imageList.get(num-1)).setArr(arrRightN);
            (imageList.get(num-1)).show();
            return;
        }
        if(e.getActionCommand().equals("左转"))
        {
            int[][]arrLeft = images[num-1].getArr();
            int[][]arrleftN = new int[arrLeft[0].length][arrLeft.length];
            for(int i=0 ; i< arrLeft.length ; i++)
                for(int j=0 ; j<arrLeft[0].length ; j++)
                    arrleftN[j][arrleftN.length-i]=arrLeft[i][j];
            images[num-1].setArr(arrleftN);
            images[num-1].show();
            return;
        }
        if(e.getActionCommand().equals("放大"))
        {
            (imageList.get(num-1)).setMax(images[num-1].getMax()+1);
            (imageList.get(num-1)).show();
            return;
        }
        if(e.getActionCommand().equals("缩小"))
        {
            (imageList.get(num-1)).setMax(images[num-1].getMax()-1);
            (imageList.get(num-1)).show();
            return;
        }
        Image image = new Image(path,e.getActionCommand(),g);
        image.show();
        images[num++]=image;
        imageList.add(image);
        if(num>100)
            num=0;


    }
}
