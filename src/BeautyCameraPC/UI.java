package BeautyCameraPC;

import javax.swing.*;
import java.awt.*;

public class UI
{
    public void initUI()
    {
        JFrame jf = new JFrame("BeautyCameraPC");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setSize(1000,1000);
        jf.setVisible(true);

        Graphics g = jf.getGraphics();
        Mouse mouse = new Mouse(g);
        mouse.setG(g);
        jf.addMouseListener(mouse);

    }

    public static void main(String []args)
    {
        UI myUI = new UI();
        myUI.initUI();
    }

}
