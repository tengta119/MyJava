package BeautyCameraPC;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyJFrame extends JFrame
{
    Image[] images=null;
    int num=0;
    Graphics g;

    public void setBufferedImages(BufferedImage[] bufferedImages)
    {
        System.out.println("MyJFrameSetBufferedImages");
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(images[0].getBufferedImages()[0],0,100,null );
        System.out.println("paint........");
    };

}
