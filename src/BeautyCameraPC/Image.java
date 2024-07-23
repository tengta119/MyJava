package BeautyCameraPC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;

public class Image
{
    public String path ;
    BufferedImage bufferedImage = null;
    int[][] arr=null;
    String name;
    Graphics g;
    public Image(String path,String n,Graphics g)
    {
        arr=getImagePixel(path);
        name = n;
        this.g=g;
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
                g.drawLine(j,i+100,j,i+100);
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
                g.fillRect(j,i+100,1,1);
            }
        }
    }
    public void drawPixelMosaic(int[][] pixelArr)
    {
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j+=10)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                Color color = new Color(red,green,blue);
                g.setColor(color);
                g.fillRect(j,i+100,10,10);
            }
        }
    }
    public void show()
    {
        switch (name)
        {
            case "原图":
                drawPixelOriginal(arr);
                break;
            case "马赛克":
                drawPixelMosaic(arr);
                break;
            case "黑白":
                drawPixelGray(arr);
                break;
        }
    }
}
