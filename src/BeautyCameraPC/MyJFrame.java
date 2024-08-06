package BeautyCameraPC;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyJFrame extends JFrame
{
    Image[] images;
    int num=0;
    Graphics g;

    public void setBufferedImages(BufferedImage[] bufferedImages)
    {
        System.out.println("MyJFrameSetBufferedImages");
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        for (Image image : images)
        {
            if(image!=null)
                g.drawImage(image.getBufferedImages()[0], 0, 100, null);
        }

        System.out.println("paint........");
    };

}
