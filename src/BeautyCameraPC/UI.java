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
        //jf.setLayout(new FlowLayout());
        Mouse mouse = new Mouse();
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.GREEN);
        northPanel.setPreferredSize(new Dimension(0,50));
        jf.add(northPanel,BorderLayout.NORTH);


        String[] name = {"原图","马赛克","黑白","撤回","右转","左转","放大","缩小"};
        for(int i=0 ; i< name.length;i++)
        {
            JButton jbu = new JButton(name[i]);
            northPanel.add(jbu);
            jbu.addActionListener(mouse);
        }
        jf.setVisible(true);
        Graphics g = jf.getGraphics();
        jf.addMouseListener(mouse);
        mouse.setG(g);
        //jf.images= mouse.images;
        jf.imageList=mouse.imageList;
    }

    public static void main(String []args)
    {
        UI myUI = new UI();
        myUI.initUI();
    }

}
