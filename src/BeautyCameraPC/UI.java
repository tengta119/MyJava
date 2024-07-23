package BeautyCameraPC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class UI
{
    public void initUI()
    {
        MyJFrame jf = new MyJFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setSize(1000,1000);
        jf.setVisible(true);
        jf.setLayout(new FlowLayout());
        Mouse mouse = new Mouse();
        String[] name = {"原图","马赛克","黑白"};
        for(int i=0 ; i< name.length;i++)
        {
            JButton jbu = new JButton(name[i]);
            jf.add(jbu);
            jbu.addActionListener(mouse);
        }
        Graphics g = jf.getGraphics();
        jf.addMouseListener(mouse);
        mouse.setG(g);
        jf.images= mouse.images;
    }

    public static void main(String []args)
    {
        UI myUI = new UI();
        myUI.initUI();
    }

}
