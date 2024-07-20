package BeautyCameraPC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mouse implements MouseListener
{
    private Graphics g;
    BufferedImage bufferedImage = null;
    public Mouse(Graphics g){this.g=g;System.out.println("construction method");}
    public Mouse(){System.out.println("Default construction method");}

    public void setG(Graphics g){this.g=g;}

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("click");
        int x=e.getX();
        int y=e.getY();
        System.out.println("x="+x+" "+"y="+y);
        String path = "D:\\Jave\\1.png";
        int[][] arr = null;

            arr = getImagePixel(path);
            drawPixelEmbossed(arr);

    }

    public int[][] getImagePixel(String path)
    {
        try
        {
            File file = new File(path);
            bufferedImage = ImageIO.read(file);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        int h=bufferedImage.getHeight();
        int w=bufferedImage.getWidth();
        int[][] pixelArr = new int[h][w];
        for(int i=0 ; i<h ; i++)
        {
            for(int j=0 ; j<w ; j++)
            {
                pixelArr[i][j]=bufferedImage.getRGB(j,i);
            }
        }
        return pixelArr;
    }

    public void drawPixelOriginal(int[][] pixelArr)
    {
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j++)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                Color color = new Color(red,green,blue);
                g.setColor(color);
                g.drawLine(j,i,j,i);
            }
        }
    }

    public void drawPixelGray(int[][] pixelArr)
    {
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j++)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                int gray = (int)(red*0.299+green*0.587+blue*0.144);
                Color color = new Color(gray,gray,gray);
                g.setColor(color);
                g.drawLine(j,i,j,i);
            }
        }
    }
    public void drawPixelMosaic(int[][] pixelArr)
    {
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j++)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                Color color = new Color(red,green,blue);
                g.setColor(color);
                g.fillOval(j, i+100, 20, 20);
            }
        }
    }

    public void drawPixelEmbossed(int[][] pixelArr)
    {
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j++)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                int embossFactor = calculateEmbossFactor(i, j, pixelArr.length, pixelArr[0].length);
                red = (int) (red * embossFactor);
                green = (int) (green * embossFactor);
                blue = (int) (blue * embossFactor);

                red = Math.max(0, Math.min(255, red));
                green = Math.max(0, Math.min(255, green));
                blue = Math.max(0, Math.min(255, blue));
                Color color = new Color(red,green,blue);

                g.setColor(color);
                g.drawLine(j,i,j,i);
            }
        }
    }
    private int calculateEmbossFactor(int x, int y, int width, int height)
    {
        double factor = 1.0;
        if (x < width / 3 || x > 2 * width / 3 || y < height / 3 || y > 2 * height / 3) {factor = 1.2;}
        else {factor = 0.8;}
        return (int) (factor * 255);
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
