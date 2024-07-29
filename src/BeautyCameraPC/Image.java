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
    int[][] arr=null;
    String name;
    Graphics g;
    private BufferedImage[] bufferedImages = new BufferedImage[1];

    public BufferedImage[] getBufferedImages()
    {
        System.out.println("ImageGetBufferedImages");
        return bufferedImages;
    }

    public Image(String path, String n, Graphics g)
    {
        arr=getImagePixel(path);
        name = n;
        this.g=g;
    }

    public int[][] getImagePixel(String path)
    {
        BufferedImage bufferedImage = null;
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
        BufferedImage bufferedImage = new BufferedImage(arr[0].length,arr.length,BufferedImage.TYPE_INT_RGB);
        Graphics bufferG = bufferedImage.getGraphics();
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j++)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                Color color = new Color(red,green,blue);
                bufferG.setColor(color);
                bufferG.drawLine(j,i,j,i+100);
            }
        }
        g.drawImage(bufferedImage,0,100,null);
        bufferedImages[0]=bufferedImage;
    }
    public void drawPixelGray(int[][] pixelArr)
    {
        BufferedImage bufferedImage = new BufferedImage(arr[0].length,arr.length,BufferedImage.TYPE_INT_RGB);
        Graphics bufferG = bufferedImage.getGraphics();
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j++)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                int gray = (int)((red+green+blue)/3);
                Color color = new Color(gray,gray,gray);
                bufferG.setColor(color);
                bufferG.fillRect(j,i,1,1);
            }
        }
        g.drawImage(bufferedImage,0,100,null);
        bufferedImages[0]=bufferedImage;
    }
    public void drawPixelMosaic(int[][] pixelArr)
    {
        BufferedImage bufferedImage = new BufferedImage(arr[0].length,arr.length,BufferedImage.TYPE_INT_RGB);
        Graphics bufferG = bufferedImage.getGraphics();
        for(int i= 0; i<pixelArr.length;i++)
        {
            for(int j=0 ; j<pixelArr[i].length;j+=10)
            {
                int pixel = pixelArr[i][j];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = (pixel >> 0) & 0xFF;
                Color color = new Color(red,green,blue);
                bufferG.setColor(color);
                bufferG.fillRect(j,i,10,10);
            }
        }
        g.drawImage(bufferedImage,0,100,null);
        bufferedImages[0]=bufferedImage;
    }
    public void withDraw(int[][] pixelArr)
    {
        drawPixelOriginal(pixelArr);
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
